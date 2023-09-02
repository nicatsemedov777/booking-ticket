package com.booking.ticket.dao;

import com.booking.ticket.model.Flight;
import com.booking.ticket.model.Person;

import java.util.List;

public interface PersonDao {
    Person getPerson();
    List<Flight> getMyFlights(int personId);

}
