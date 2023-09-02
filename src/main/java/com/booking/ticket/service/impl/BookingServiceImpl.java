package com.booking.ticket.service.impl;

import com.booking.ticket.controller.PersonController;
import com.booking.ticket.dao.impl.BookingDaoImpl;
import com.booking.ticket.model.Flight;
import com.booking.ticket.model.FlightDto;
import com.booking.ticket.service.BookingService;

public class BookingServiceImpl implements BookingService {
    private final BookingDaoImpl bookingDaoImpl;

    public BookingServiceImpl(BookingDaoImpl bookingDao) {
        this.bookingDaoImpl = bookingDao;
    }


    @Override
    public void reserveBooking(FlightDto flightDto, Flight flight, PersonController personController) {
        bookingDaoImpl.reserveBooking(flightDto,flight,personController);

    }

    @Override
    public void cancelBooking(int bookingNumber) {
        bookingDaoImpl.cancelBooking(bookingNumber);
    }
}
