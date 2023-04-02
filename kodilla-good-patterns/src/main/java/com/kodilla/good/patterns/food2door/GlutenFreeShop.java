package com.kodilla.good.patterns.food2door;

public class GlutenFreeShop implements Supplier {
    public boolean process(Order order) {
        return sendOrderToSubcontractor(order);
    }

    private boolean sendOrderToSubcontractor(Order order) {
        //code for sending the order to a subcontractor, returning true if subcontractor delivers product
        return true;
    }
}

