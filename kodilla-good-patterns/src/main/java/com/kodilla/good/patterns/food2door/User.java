package com.kodilla.good.patterns.food2door;

public class User {
    private String name;
    private String deliveryAddress;

    public User(String name, String deliveryAddress) {
        this.name = name;
        this.deliveryAddress = deliveryAddress;
    }

    public String getName() {
        return name;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }
}
