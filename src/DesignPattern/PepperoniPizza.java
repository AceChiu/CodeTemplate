package DesignPattern;

public class PepperoniPizza implements Pizza {

    @Override
    public void prepare() {
         System.out.println("Prepare Pepperoni Pizza");
    }

    @Override
    public void cook() {
         System.out.println("Cook Pepperoni Pizza");
    }
}
