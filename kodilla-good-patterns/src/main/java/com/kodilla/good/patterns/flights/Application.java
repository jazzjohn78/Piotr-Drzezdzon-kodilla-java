package com.kodilla.good.patterns.flights;

public class Application {
    public static void main(String[] args) {
        TimeTable timeTable = new TimeTable();

        System.out.println("\nFlights from Poznań:");
        timeTable.getFlightsFrom("Poznań");

        System.out.println("\nFlights to Poznań:");
        timeTable.getFlightsTo("Poznań");

        System.out.println("\nAll flights from Gdańsk to Wrocław:");
        timeTable.getFlightsFromTo("Gdańsk", "Wrocław");
    }
}
