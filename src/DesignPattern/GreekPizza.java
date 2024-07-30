package DesignPattern;

public class GreekPizza implements Pizza {
    @Override
    public void prepare() {
         System.out.println("Prepare Greek Pizza");
    }

    @Override
    public void cook() {
        System.out.println("Cook Greek Pizza");
    }
}
