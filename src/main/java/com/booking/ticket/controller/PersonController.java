package com.booking.ticket.controller;

import com.booking.ticket.model.Flight;
import com.booking.ticket.model.Person;
import com.booking.ticket.service.PersonService;
import com.booking.ticket.service.impl.PersonServiceImpl;

import java.util.List;

public class PersonController {
    private final PersonServiceImpl personService;

    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    public Person getPerson(){
        return personService.getPerson();
    }

    public List<Flight> getMyFlights(int personId){
        return personService.getMyFlights(personId);
    }
}
