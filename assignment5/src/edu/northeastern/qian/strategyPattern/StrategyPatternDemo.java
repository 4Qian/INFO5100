package edu.northeastern.qian.strategyPattern;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("1234",10);
        Item item2 = new Item("5678",40);
        cart.addItem(item1);
        cart.addItem(item2);
        cart.pay(new PaypalStrategy("myemail@example.com"));
        cart.pay(new CreditCardStrategy( "1234567890123456"));
    }
}
