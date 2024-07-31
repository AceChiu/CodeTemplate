package Thread;

public class ThreadRunner {
    public static void main(String[] args) {
        System.out.println("Start Process");
        ExtendThread thread1 = new ExtendThread(5000);
        thread1.start();
        ExtendThread thread2 = new ExtendThread(4000);
        thread2.start();

        Thread thread3 = new Thread(new ImplementRunnable(3000));
        thread3.start();
        Thread thread4 = new Thread(new ImplementRunnable(2000));
        thread4.start();
        System.out.println("Finish Process");


    }
}

