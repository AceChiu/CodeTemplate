package Thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestMulti {
        public static void main(String[] args) {
            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(100);
            int totalCont = 10000;
            for (int i = 0; i < totalCont; i++) {
                final int finalI = i;
                executorService.schedule(() -> {
                    if(getTestOk()) {
                        setTestOk(false);
                        System.out.printf("I'm tread %s, I got the lock%n", finalI);
                    }
                }, 5, TimeUnit.SECONDS);
            }

        }

        public static boolean testOk = true;

        synchronized public static boolean getTestOk() {
            return testOk;
        }

        synchronized public static void setTestOk(boolean testOk) {
            TestMulti.testOk = testOk;
        }
}
