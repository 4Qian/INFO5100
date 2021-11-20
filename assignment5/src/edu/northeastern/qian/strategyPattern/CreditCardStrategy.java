package edu.northeastern.qian.strategyPattern;

public class CreditCardStrategy implements PaymentStrategy{

    private String cardNumber;

    public CreditCardStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    @Override
    public void pay (int amount) {
        System.out.println("CreditCard : $" + amount);
    }
}
