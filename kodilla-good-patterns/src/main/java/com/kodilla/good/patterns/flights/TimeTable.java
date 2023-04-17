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

    public Set<Flight> getFlightsFrom(String departure) {
        return flightSet.stream()
                .filter(f -> f.getDeparture().equals(departure))
                .collect(Collectors.toSet());
    }

    public Set<Flight> getFlightsTo(String destination) {
        return flightSet.stream()
                .filter(f -> f.getDestination().equals(destination))
                .collect(Collectors.toSet());
    }

    public Set<String> getFlightsFromTo(String departure, String destination) {
        //direct flights
        Set resultSet =  flightSet.stream()
                .filter(f -> f.getDeparture().equals(departure))
                .filter(f -> f.getDestination().equals(destination))
                .map(f -> f.getDeparture() + " -> " + f.getDestination())
                .collect(Collectors.toSet());
        //indirect flights
        Set possibleLayoversSet = flightSet.stream()
                .filter(f -> f.getDeparture().equals(departure))
                .map(f -> f.getDestination())
                .collect(Collectors.toSet());

        flightSet.stream()
                .filter(f -> possibleLayoversSet.contains(f.getDeparture()))
                .filter(f -> f.getDestination().equals(destination))
                .map(f -> departure + " -> " + f.getDeparture() + " -> " + f.getDestination())
                .forEach(resultSet::add);

        return resultSet;
    }

    public Set<String> getFlightsFromViaTo(String departure, String via, String destination) {
        String layover = flightSet.stream()
                .filter(f -> f.getDeparture().equals(departure))
                .filter(f -> f.getDestination().equals(via))
                .map(f -> f.getDestination())
                .collect(Collectors.joining(""));

        return flightSet.stream()
                .filter(f -> f.getDeparture().equals(layover))
                .filter(f -> f.getDestination().equals(destination))
                .map(f -> departure + " -> " + f.getDeparture() + " -> " + f.getDestination())
                .collect(Collectors.toSet());
    }
}