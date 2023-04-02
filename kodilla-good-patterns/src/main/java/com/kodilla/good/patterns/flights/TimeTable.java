package com.kodilla.good.patterns.flights;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class TimeTable {
    private final Set<Flight> flightSet;

    public TimeTable() {
        flightSet = new HashSet<>();
        flightSet.add(new Flight("Poznań", "Gdańsk"));
        flightSet.add(new Flight("Poznań", "Wrocław"));
        flightSet.add(new Flight("Poznań", "Kraków"));
        flightSet.add(new Flight("Gdańsk", "Poznań"));
        flightSet.add(new Flight("Gdańsk", "Wrocław"));
        flightSet.add(new Flight("Gdańsk", "Kraków"));
        flightSet.add(new Flight("Kraków", "Poznań"));
        flightSet.add(new Flight("Kraków", "Wrocław"));
        flightSet.add(new Flight("Wrocław", "Poznań"));
        flightSet.add(new Flight("Wrocław", "Gdańsk"));
    }

    public void getFlightsFrom(String departure) {
        flightSet.stream()
                .filter(f -> f.getDeparture().equals(departure))
                .map(f -> f.getDeparture() + " -> " + f.getDestination())
                .forEach(System.out::println);
    }

    public void getFlightsTo(String destination) {
        flightSet.stream()
                .filter(f -> f.getDestination().equals(destination))
                .map(f -> f.getDeparture() + " -> " + f.getDestination())
                .forEach(System.out::println);
    }

    public void getFlightsFromTo(String departure, String destination) {
        //direct flights
        flightSet.stream()
                .filter(f -> f.getDeparture().equals(departure))
                .filter(f -> f.getDestination().equals(destination))
                .map(f -> f.getDeparture() + " -> " + f.getDestination())
                .forEach(System.out::println);
        //indirect flights
        Set possibleLayoversSet = flightSet.stream()
                .filter(f -> f.getDeparture().equals(departure))
                .map(f -> f.getDestination())
                .collect(Collectors.toSet());

        flightSet.stream()
                .filter(f -> possibleLayoversSet.contains(f.getDeparture()))
                .filter(f -> f.getDestination().equals(destination))
                .map(f -> departure + " -> " + f.getDeparture() + " -> " + f.getDestination())
                .forEach(System.out::println);

    }
}
