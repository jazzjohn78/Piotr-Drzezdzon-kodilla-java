package com.kodilla.good.patterns.challenges;

public class ProductOrder {
    private User user;
    private Product product;
    private Double quantity;

    public ProductOrder(final User user, final Product product, final Double quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public Double getQuantity() {
        return quantity;
    }
}
