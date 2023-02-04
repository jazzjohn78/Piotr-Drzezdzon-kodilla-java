package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollectorTestSuite {
    public static int testCounter = 0;
    @BeforeAll
    public static void beforeAllTests(){
        System.out.println("Starting tests...");
    }

    @AfterAll
    public static void afterAllTests(){
        System.out.println("Tests finished.");
    }

    @BeforeEach
    public void beforeEachTest(){
        testCounter++;
        System.out.println("Executing test #" + testCounter);
    }

    @Nested
    @DisplayName("tests for adding figure")
    class TestAddingFigure {
        @Test
        void testAddSquare(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square("square1", 16.0);

            //When
            shapeCollector.addFigure(square);

            //Then
            Assertions.assertEquals(1, shapeCollector.getShapesQuantity());
        }

        @Test
        void testAddCircle(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle("circle1", 3.14159);

            //When
            shapeCollector.addFigure(circle);

            //Then
            Assertions.assertEquals(1, shapeCollector.getShapesQuantity());
        }

        @Test
        void testAddTriangle(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle("triangle1", 4.5);

            //When
            shapeCollector.addFigure(triangle);

            //Then
            Assertions.assertEquals(1, shapeCollector.getShapesQuantity());
        }
    }

    @Nested
    @DisplayName("tests for removing figure")
    class TestRemovingFigure {
        @Test
        void testRemoveSquareMissing(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square("square1", 16.0);

            //When
            boolean result = shapeCollector.removeFigure(square);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveSquare(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square("square1", 16.0);
            shapeCollector.addFigure(square);

            //When
            boolean result = shapeCollector.removeFigure(square);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapesQuantity());
        }

        @Test
        void testRemoveCircleMissing(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle("circle1", 3.14159);

            //When
            boolean result = shapeCollector.removeFigure(circle);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveCircle(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle("circle1", 3.14159);
            shapeCollector.addFigure(circle);

            //When
            boolean result = shapeCollector.removeFigure(circle);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapesQuantity());
        }

        @Test
        void testRemoveTriangleMissing(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle("triangle1", 4.5);

            //When
            boolean result = shapeCollector.removeFigure(triangle);

            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveTriangle(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle("triangle1", 4.5);
            shapeCollector.addFigure(triangle);

            //When
            boolean result = shapeCollector.removeFigure(triangle);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapesQuantity());
        }
    }

    @Nested
    @DisplayName("tests for getting figure")
    class TestGettingFigure {
        @Test
        void testGetSquare(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square("square1", 16.0);
            shapeCollector.addFigure(square);

            //When
            Square retrievedShape;
            retrievedShape = (Square) shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals("square1", retrievedShape.getShapeName());
            Assertions.assertEquals(16.0, retrievedShape.getField());
        }

        @Test
        void testGetCircle(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle("circle1", 3.14159);
            shapeCollector.addFigure(circle);

            //When
            Circle retrievedShape;
            retrievedShape = (Circle) shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals("circle1", retrievedShape.getShapeName());
            Assertions.assertEquals(3.14159, retrievedShape.getField());
        }

        @Test
        void testGetTriangle(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle("triangle1", 4.5);
            shapeCollector.addFigure(triangle);

            //When
            Triangle retrievedShape;
            retrievedShape = (Triangle) shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals("triangle1", retrievedShape.getShapeName());
            Assertions.assertEquals(4.5, retrievedShape.getField());
        }
    }

    @Nested
    @DisplayName("tests for showing figures")
    class TestShowingFigures {
        @Test
        void testShowFiguresEmpty(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            String result = shapeCollector.showFigures();

            //Then
            Assertions.assertEquals("", result);
        }

        @Test
        void testShowFigures(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square("square1", 16.0);
            shapeCollector.addFigure(square);
            Circle circle = new Circle("circle1", 3.14159);
            shapeCollector.addFigure(circle);
            Triangle triangle = new Triangle("triangle1", 4.5);
            shapeCollector.addFigure(triangle);

            //When
            String result = shapeCollector.showFigures();

            //Then
            Assertions.assertEquals("square1,circle1,triangle1", result);
        }
    }
}
