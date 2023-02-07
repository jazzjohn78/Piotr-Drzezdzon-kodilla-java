package com.kodilla.exception.test;

public class FlightApp {

    public static void main(String[] args) {
        FlightSearch flightSearch = new FlightSearch();
        Flight flight;
        String flightInfo;

        flight = new Flight("Poznań Lawica", "Warszawa Lotnisko Chopina");
        try {
            flightInfo = flightSearch.findFlight(flight);
            System.out.println("Przelot z: " + flight.getDepartureAirport() + " do: " + flight.getArrivalAirport() + " - " + flightInfo);
        } catch (RouteNotFoundException e) {
            System.out.println("Przelot z: " + flight.getDepartureAirport() + " do: " + flight.getArrivalAirport() + " - " + "podano niewłaściwe lotnisko - jesteś pewien, że ono istnieje?");
        }

        flight = new Flight("Poznań Lawica", "Centralny Port Komunikacyjny Stanisławów");
        try {
            flightInfo = flightSearch.findFlight(flight);
            System.out.println("Przelot z: " + flight.getDepartureAirport() + " do: " + flight.getArrivalAirport() + " - " + flightInfo);
        } catch (RouteNotFoundException e) {
            System.out.println("Przelot z: " + flight.getDepartureAirport() + " do: " + flight.getArrivalAirport() + " - " + "podano niewłaściwe lotnisko - jesteś pewien, że ono istnieje?");
        }

        flight = new Flight("Poznań Lawica", "Port Lotniczy Radom");
        try {
            flightInfo = flightSearch.findFlight(flight);
            System.out.println("Przelot z: " + flight.getDepartureAirport() + " do: " + flight.getArrivalAirport() + " - " + flightInfo);
        } catch (RouteNotFoundException e) {
            System.out.println("Przelot z: " + flight.getDepartureAirport() + " do: " + flight.getArrivalAirport() + " - " + "podano niewłaściwe lotnisko - jesteś pewien, że ono istnieje?");
        }
    }
}
