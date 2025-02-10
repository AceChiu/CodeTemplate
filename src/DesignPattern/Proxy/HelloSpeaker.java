package DesignPattern.Proxy;

public class HelloSpeaker implements Hello {
     public void hello(String name) {
        System.out.println("Hello, " + name);
    }
}
