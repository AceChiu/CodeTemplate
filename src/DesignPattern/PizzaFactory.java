package DesignPattern;

public class PizzaFactory {
    public Pizza creatPizza(String flavor) {
        Pizza pizza = null;;
        if ("cheese".equals(flavor)) {
            pizza = new CheesePizza();
        } else if ("greek".equals(flavor)) {
            pizza = new GreekPizza();
        } else if ("pepperoni".equals(flavor)) {
            pizza = new PepperoniPizza();
        }
        return pizza;
    }
}
