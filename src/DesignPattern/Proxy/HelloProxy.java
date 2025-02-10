package DesignPattern.Proxy;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloProxy implements Hello {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    private Hello helloObject;

    public HelloProxy(Hello helloObject) {
        this.helloObject = helloObject;
    }

    public void hello(String name) {
        // 日誌服務
        log("hello method starts....");

        // 執行商務邏輯
        helloObject.hello(name);

        // 日誌服務
        log("hello method ends....");
    }

    private void log(String msg) {
        logger.log(Level.INFO, msg);
    }
}