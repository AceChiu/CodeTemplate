package Thread;

public class ImplementRunnable implements Runnable {

    private long waitTime;

    public ImplementRunnable(long waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        System.out.println("implement runnable executing:" + waitTime);
        try {
            java.lang.Thread.sleep(waitTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("implement runnable executed:" + waitTime);
    }
}
