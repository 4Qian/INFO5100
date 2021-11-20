package edu.northeastern.qian.strategyPattern;

public class Item {
    private String Id;
    private int price;

    public Item (String Id, int price) {
        this.Id = Id;
        this.price = price;
    }

    public String getId() {
        return Id;
    }

    public int getPrice() {
        return price;
    }
}
