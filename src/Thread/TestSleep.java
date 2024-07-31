package Thread;

public class TestSleep implements Runnable{
    //票數
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true){
            if(ticketNums <= 0){
                break;
            }
            //模擬延遲，如果沒有延遲，可能看不到問題，因為CPU速度很快，小明或任何人可以一次拿走所有票
            //但加入延遲可以避免這種獨佔狀況，可以放大細節看出資源搶奪問題
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"==>拿到了第"+ticketNums--+"票");
        }
    }

    public static void main(String[] args) {
        TestSleep ticket = new TestSleep();

        new Thread(ticket,"小明").start();
        new Thread(ticket, "老師").start();
        new Thread(ticket, "黃牛").start();
    }
}
