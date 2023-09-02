package com.booking.ticket.service.impl;

import com.booking.ticket.dao.impl.FlightDaoImpl;
import com.booking.ticket.model.Flight;
import com.booking.ticket.model.FlightDto;
import com.booking.ticket.service.FlightService;

import java.util.List;

public class FlightServiceImpl implements FlightService {
    private final FlightDaoImpl flightDao;

    public FlightServiceImpl(FlightDaoImpl flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public Flight getFlightsByFlightNumber(String flightNumber) {
        return flightDao.getFlightsByFlightNumber(flightNumber);
    }

    @Override
    public List<Flight> getALlFlightsFromOneOfCity(String departureCity) {
        return flightDao.getALlFlightsFromOneOfCity(departureCity);
    }

    @Override
    public List<Flight> searchTicketForBooking(FlightDto flightDto) {
        return flightDao.searchTicketForBooking(flightDto);
    }
}
