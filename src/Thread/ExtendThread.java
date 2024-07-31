package Thread;

public class ExtendThread extends Thread {

    private long waitTime;

    public ExtendThread(long waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public void run() {
        System.out.println("extend thread executing:" + waitTime);
        try {
            java.lang.Thread.sleep(waitTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("extend thread executed:" + waitTime);
    }
}
