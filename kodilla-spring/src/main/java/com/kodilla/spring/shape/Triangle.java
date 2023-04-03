package com.kodilla.spring.shape;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape {
    public String getShapeName() {
        return "This is a triangle.";
    }
}
