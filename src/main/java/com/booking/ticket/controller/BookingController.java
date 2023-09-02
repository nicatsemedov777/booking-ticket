package com.booking.ticket.controller;

import com.booking.ticket.model.Flight;
import com.booking.ticket.model.FlightDto;
import com.booking.ticket.service.BookingService;
import com.booking.ticket.service.impl.BookingServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

public class BookingController {
    private final BookingServiceImpl bookingService;

    public BookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }

    public void reserveBooking(FlightDto flightDto,Flight flight, PersonController personController){
        bookingService.reserveBooking(flightDto,flight,personController);
    }

    public void cancelBooking(int bookingNumber) {
         bookingService.cancelBooking(bookingNumber);
    }

}
