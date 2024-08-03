package Thread;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();

        new Thread(testLock2, "A").start();
        new Thread(testLock2, "B").start();
        new Thread(testLock2, "C").start();
    }
}


class TestLock2 implements Runnable {

    int ticketNums = 1000;

    //定義lock鎖
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            try {
                lock.lock(); //加鎖
                if (ticketNums > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNums-- + "張票");
                } else {
                    break;
                }
            } finally {
                lock.unlock(); //解鎖
            }
        }
    }
}