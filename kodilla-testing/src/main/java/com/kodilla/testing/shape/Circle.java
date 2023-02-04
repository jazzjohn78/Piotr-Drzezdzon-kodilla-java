package com.kodilla.testing.shape;

public class Circle implements Shape {
    private String name;
    private Double field;

    public Circle(String name, Double field) {
        this.name = name;
        this.field = field;
    }

    public String getShapeName() {
        return name;
    }

    public Double getField() {
        return field;
    }
}
