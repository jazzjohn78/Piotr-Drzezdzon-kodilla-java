package com.kodilla.good.patterns.food2door;

public class Order {
    private User user;
    private Supplier supplier;
    private String product;
    private Double quantity;

    public Order(final User user, final Supplier supplier, final String product, final Double quantity) {
        this.user = user;
        this.supplier = supplier;
        this.product = product;
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public String getProduct() {
        return product;
    }

    public Double getQuantity() {
        return quantity;
    }
}
