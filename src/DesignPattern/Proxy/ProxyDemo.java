package DesignPattern.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        Hello proxy =
            new HelloProxy(new HelloSpeaker());
        proxy.hello("ace");

        LogHandler logHandler  = new LogHandler();

        Hello helloProxy =
                (Hello) logHandler.bind(new HelloSpeaker());
        helloProxy.hello("ace");
    }
}
