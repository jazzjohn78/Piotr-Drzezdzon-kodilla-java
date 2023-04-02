package com.kodilla.good.patterns.food2door;

public class HealthyShop implements Supplier {
    public boolean process(Order order) {
        if(productInStock(order.getProduct())){
            boolean isAssignedToDriver = assignDriver(order);
            if(isAssignedToDriver) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean productInStock(String product) {
        //code for checking if product is in stock
        return true;
    }

    private boolean assignDriver(Order order) {
        //code for assigning order to a driver and returning true if driver available
        return true;
    }
}
