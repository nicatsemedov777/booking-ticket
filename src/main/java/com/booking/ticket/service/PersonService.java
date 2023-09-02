package com.booking.ticket.service;

import com.booking.ticket.model.Flight;
import com.booking.ticket.model.Person;

import java.util.List;

public interface PersonService {

    Person getPerson();
    List<Flight> getMyFlights(int personId);

}
