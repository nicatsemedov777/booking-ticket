package com.booking.ticket.service;

import com.booking.ticket.model.Flight;
import com.booking.ticket.model.FlightDto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    Flight getFlightsByFlightNumber(String flightNumber);

    List<Flight> getALlFlightsFromOneOfCity(String departureCity);

    List<Flight> searchTicketForBooking(FlightDto flightDto);
}
