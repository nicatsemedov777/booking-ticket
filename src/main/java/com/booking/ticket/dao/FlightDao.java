package com.booking.ticket.dao;

import com.booking.ticket.model.Flight;
import com.booking.ticket.model.FlightDto;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightDao {
    Flight getFlightsByFlightNumber(String flightNumber);

    List<Flight> getALlFlightsFromOneOfCity(String departureCity);

    List<Flight> searchTicketForBooking(FlightDto flightDto);


}
