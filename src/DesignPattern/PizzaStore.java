package DesignPattern;

public class PizzaStore {
    PizzaFactory factory;

    public PizzaStore(PizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String flavor) {
        Pizza pizza = factory.creatPizza(flavor);
        pizza.prepare();
        pizza.cook();
        return pizza;
    }
}
