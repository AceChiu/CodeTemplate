package DesignPattern.Factory;

public class Main {
    public static void main(String[] args) {
      PizzaStore pizzaStore = new PizzaStore(new PizzaFactory());
      pizzaStore.orderPizza("cheese");
    }
}