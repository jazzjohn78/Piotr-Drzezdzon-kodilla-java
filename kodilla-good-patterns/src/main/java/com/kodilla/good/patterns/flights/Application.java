package com.kodilla.good.patterns.flights;

import java.sql.SQLOutput;

public class Application {
    public static void main(String[] args) {
        TimeTable timeTable = new TimeTable();

        System.out.println("\nFlights from Poznań:");
        timeTable.getFlightsFrom("Poznań").stream()
                .map(f -> f.getDeparture() + " -> " + f.getDestination())
                .forEach(System.out::println);

        System.out.println("\nFlights to Poznań:");
        timeTable.getFlightsTo("Poznań").stream()
                .map(f -> f.getDeparture() + " -> " + f.getDestination())
                .forEach(System.out::println);

        System.out.println("\nAll flights from Gdańsk to Wrocław:");
        timeTable.getFlightsFromTo("Gdańsk", "Wrocław").stream()
                .forEach(System.out::println);

        System.out.println("\nFlights from Gdańsk via Kraków To Wrocław:");
        timeTable.getFlightsFromViaTo("Gdańsk", "Kraków", "Wrocław").stream()
                .forEach(System.out::println);
    }
}
