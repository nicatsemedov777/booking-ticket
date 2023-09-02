package com.booking.ticket.dao;

import com.booking.ticket.controller.PersonController;
import com.booking.ticket.model.Flight;
import com.booking.ticket.model.FlightDto;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingDao {

    void reserveBooking(FlightDto flightDto,Flight flight, PersonController personController);

    void cancelBooking(int bookingNumber);
}
