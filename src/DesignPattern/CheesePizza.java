package DesignPattern;

public class CheesePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Prepare Cheese Pizza");
    }

    @Override
    public void cook() {
        System.out.println("Cook Cheese Pizza");
    }
}
