package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        //test klasy SimpleUser
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUsername();
        if(result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        //test klasy Calculator
        Calculator calculator = new Calculator();
        double addResult = calculator.add(2.5, 49.1);
        if(addResult == 51.6){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
        double subtractResult = calculator.subtract(142.12, 34.53);
        if(subtractResult == 107.59){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
    }
}
