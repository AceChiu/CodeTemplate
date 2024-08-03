package Thread;

public class SafeBuyTicketSync {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station, "小王").start();
        new Thread(station, "小明").start();
        new Thread(station, "黃牛").start();
    }
}


class BuyTicket implements Runnable {

    //票
    private int ticketNums = 10;
    boolean flag = true;

    @Override
    public void run() {
        //買票
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //synchronized 同步方法，鎖的是this
    private synchronized void buy() throws InterruptedException {
        //判斷是否有票
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        //模擬延遲(放大問題)
        Thread.sleep(200);
        //買票
        System.out.println(Thread.currentThread().getName() + "拿到" + ticketNums--);
    }
}