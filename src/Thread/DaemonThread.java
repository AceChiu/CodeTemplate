package Thread;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonThread {
    public static void main(String[] args) throws Exception {
        userThread();
        daemonThread();

    }
    public static void userThread() throws Exception {
        Executors.newSingleThreadScheduledExecutor(runnable -> {
            java.lang.Thread thread = new java.lang.Thread(runnable,"test-user-thread");
            thread.setDaemon(false);
            return thread;
        }).scheduleWithFixedDelay(() -> { // 该任务会一直执行
            System.out.println("user thread executing.");
            try {
                java.lang.Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("user thread executed.");
        }, 0, 1, TimeUnit.SECONDS);

        System.out.println("test daemon thread");
        java.lang.Thread.sleep(2000);
        System.out.println("test daemon thread done");
    }

    public static void daemonThread() throws Exception {
        Executors.newSingleThreadScheduledExecutor(runnable -> {
            java.lang.Thread thread = new java.lang.Thread(runnable,"test-daemon-thread");
            thread.setDaemon(true);
            return thread;
        }).scheduleWithFixedDelay(() -> { // 该任务会因为 main 退出而中断
            System.out.println("daemon thread executing.");
            try {
                java.lang.Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("daemon thread executed.");
        }, 0, 1, TimeUnit.SECONDS);

        System.out.println("test daemon thread");
        java.lang.Thread.sleep(2000);
        System.out.println("test daemon thread done");
    }
}
