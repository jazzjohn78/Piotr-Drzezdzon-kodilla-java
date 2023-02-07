package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public String findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> flightMap = new HashMap<>();
        flightMap.put("Poznań Lawica", true);
        flightMap.put("Warszawa Lotnisko Chopina", true);
        flightMap.put("Centralny Port Komunikacyjny Stanisławów", false);

        Boolean airportsExist = flightMap.containsKey(flight.getDepartureAirport()) && flightMap.containsKey(flight.getArrivalAirport());
        if(airportsExist) {
            Boolean airportsActive = flightMap.get(flight.getDepartureAirport()) && flightMap.get(flight.getArrivalAirport());
            if(airportsActive) {
                return "połączenie dostępne";
            } else {
                return "lotnisko nieczynne, połączenie niedostępne";
            }
        } else {
            throw new RouteNotFoundException("Airport not found in the map");
        }
    }
}
