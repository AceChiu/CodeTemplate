package DesignPattern.Strategy;

/*

The Strategy pattern is useful when a primary action can be implemented in multiple ways. For example, payment processing is a core action, but there are various ways to execute it, such as paying via PayPal, credit card, or bank transfer.

Implementation steps:
1. Define a Payment interface that declares a pay() method.
2. Create three concrete classes: PayPalPayment, CreditCardPayment, and TransferPayment, all of which implement the Payment interface.
3. Each concrete class overrides the pay() method to implement its specific payment logic.
4. Implement a PaymentContext class that maintains a reference to a Payment instance. This class provides a payMoney(Payment payment) method, which accepts a Payment object and invokes its pay() method to execute the transaction.
5. When using PaymentContext, instantiate a specific Payment implementation based on business requirements and pass it to the payMoney() method, enabling dynamic selection of the payment strategy.

Satisfy
    1. Single Responsibility Principle, SRP, PayByCreditCard & PayByPayPal are responsible in they item
    2. Open/Closed Principle, OCP, if there are new payment method, just create a new payment class.
    3.
 */

public interface PayStrategy {
    boolean pay(int paymentAmount);

    void collectPaymentDetails();
}
