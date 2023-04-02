package com.kodilla.good.patterns.food2door;

public class Application {
    public static void main(String[] args) {
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        HealthyShop healthyShop = new HealthyShop();
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();

        User user = new User("Antoni Modny", "ul. Wąska 1, 78-100 Kołobrzeg");

        boolean isOrdered1 = extraFoodShop.process(new Order(user, extraFoodShop, "jajka", 60.0));
        boolean isOrdered2 = healthyShop.process(new Order(user, healthyShop, "jabłka", 5.0));
        boolean isOrdered3 = glutenFreeShop.process(new Order(user, glutenFreeShop, "woda", 6.0));

        System.out.println(isOrdered1);
        System.out.println(isOrdered2);
        System.out.println(isOrdered3);
    }
}
