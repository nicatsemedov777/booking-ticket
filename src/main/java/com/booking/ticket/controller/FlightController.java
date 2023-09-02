package com.booking.ticket.controller;

import com.booking.ticket.model.Flight;
import com.booking.ticket.model.FlightDto;
import com.booking.ticket.service.impl.FlightServiceImpl;

import java.util.List;

public class FlightController {
    private final FlightServiceImpl flightService;

    public FlightController(FlightServiceImpl flightService) {
        this.flightService = flightService;
    }

    public List<Flight> searchTicketForBooking(FlightDto flightDto) {
        return flightService.searchTicketForBooking(flightDto);
    }
    public List<Flight> getAllFlightsFromOneOfCity(String departureCity) {
        return flightService.getALlFlightsFromOneOfCity(departureCity);
    }

    public Flight getFlightsByFlightNumber(String flightNumber) {
        return flightService.getFlightsByFlightNumber(flightNumber);
    }
}
