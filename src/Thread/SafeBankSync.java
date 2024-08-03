package Thread;

public class SafeBankSync {

    public static void main(String[] args) {
        Account account = new Account(1000, "結婚基金");

        Drawing you = new Drawing(account, 50, "你");
        Drawing girlFriend = new Drawing(account, 100, "girlFriend");

        you.start();
        girlFriend.start();
    }

    //帳戶
    static class Account {
        int money;
        String name;

        public Account(int money, String name) {
            this.money = money;
            this.name = name;
        }
    }

    //銀行，模擬領錢
    static class Drawing extends Thread {
        Account account; //帳戶
        //領了多少錢
        int drawingMoney;
        //現在手裡有多少錢
        int nowMoney;

        public Drawing(Account account, int drawingMoney, String name) {
            super(name);
            this.account = account;
            this.drawingMoney = drawingMoney;
        }

        //領錢
        //synchronized預設鎖的是this，這裡的this就是Drawing，但我們要鎖的其實是帳戶account
        //但是drawing分別由你和女朋友兩個產生兩個物件(ATM領錢跟手機領錢不衝突)
        //對於不同物件，並不是同步問題，這裡使用鎖就鎖不住，等於是兩邊各自加鎖
        @Override
        public void run() {

            //鎖的物件就是變化的量，需要增刪改
            synchronized (account) {
                //判斷有沒有錢
                if (account.money - drawingMoney < 0) {
                    System.out.println(Thread.currentThread().getName() + "錢不夠，領不了");
                    return;
                }

                //sleep可以放大問題的發生性
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //卡內餘額 = 餘額 - 你領的錢
                account.money = account.money - drawingMoney;
                //你手裡的錢
                nowMoney = nowMoney + drawingMoney;

                System.out.println(this.getName() + "領取錢:" + nowMoney);
                System.out.println(account.name + "餘額為:" + account.money);
                //Thread.currentThread().getName() = this.getName()
            }
        }
    }
}
