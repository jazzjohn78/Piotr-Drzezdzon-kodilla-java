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
        int addResult = calculator.add(2, 49);
        if(addResult == 51){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
        int subtractResult = calculator.subtract(142, 34);
        if(subtractResult == 108){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
    }
}
