package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapes= new ArrayList<>();
    public void addFigure(Shape shape){
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape){
        if(shapes.contains(shape)){
            shapes.remove(shape);
            return true;
        }
        return false;
    }

    public Shape getFigure(int n){
        if(n >= 0 && n <shapes.size()){
            return shapes.get(n);
        }
        return null;
    }

    public String showFigures(){
        String result = "";
        for(int i = 0; i < shapes.size(); i++){
            result += shapes.get(i).getShapeName();
            if(i < shapes.size() - 1) result += ",";
        }
        return result;
    }

    public int getShapesQuantity(){
        return shapes.size();
    }
}
