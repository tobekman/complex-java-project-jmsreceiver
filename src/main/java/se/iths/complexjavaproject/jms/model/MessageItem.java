package se.iths.complexjavaproject.jms.model;

public class MessageItem {

    private String name;
    private double price;

    public MessageItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public MessageItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
