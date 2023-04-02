package com.kodilla.good.patterns.flights;

public class Flight {
    private final String departure;
    private final String destination;

    public Flight(final String departure, final String destination) {
        this.departure = departure;
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public boolean equals(Object o){
        Flight f = (Flight) o;
        return (departure.equals(f.getDeparture()) && destination.equals(f.getDestination()));
    }

    @Override
    public int hashCode() {
        return departure.length();
    }
}
