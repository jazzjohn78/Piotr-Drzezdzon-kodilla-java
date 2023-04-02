package com.kodilla;

import com.kodilla.good.patterns.challenges.*;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //ProductOrderService runner
        ProductOrderService productOrderService = new ProductOrderService(new MailService(), new ProductOrderProcessor(), new ProductOrderRepository());
        User user = new User("Antoni Modny", "ul. Wąska 1, 78-100 Kołobrzeg");
        ProductOrder productOrder = new ProductOrder(user, new Product("sznurówki"), 3.0);
        productOrderService.process(productOrder);
    }
}