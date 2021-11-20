package edu.northeastern.qian.strategyPattern;

public class PaypalStrategy implements PaymentStrategy{
    private String email;

    public PaypalStrategy(String email) {
        this.email = email;
    }
    @Override
    public void pay (int amount) {
        System.out.println("Paypal : $" + amount);
    }
}
