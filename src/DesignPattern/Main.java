package DesignPattern;

import Algorithm.BinaryAndDecimal;

public class Main {
    public static void main(String[] args) {
      PizzaStore pizzaStore = new PizzaStore(new PizzaFactory());
      pizzaStore.orderPizza("cheese");
    }
}