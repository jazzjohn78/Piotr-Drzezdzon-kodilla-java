package com.kodilla.good.patterns.food2door;

public class ExtraFoodShop implements Supplier {
    public boolean process(Order order) {
        String address = order.getUser().getDeliveryAddress();
        if(productInStock(order.getProduct()) && addressInDeliveryArea(address)){
            //process delivery code
            return true;
        } else {
            return false;
        }
    }

    private boolean productInStock(String product) {
        //code for checking if product is in stock
        return true;
    }

    private boolean addressInDeliveryArea(String address) {
        //code for checking if delivery address is in delivery area
        return true;
    }
}
