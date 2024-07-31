package Thread;

public class TestStop implements Runnable {

    //1.設定一個flag
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run....Thread!" + i++);
        }
    }

    //2.設定一個公開的方法停止線程，轉換flag值
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if (i == 900) {
                //調用stop方法切換flag值，讓線程停止
                testStop.stop();
                System.out.println("線程該停止了");
            }
        }
    }
}

