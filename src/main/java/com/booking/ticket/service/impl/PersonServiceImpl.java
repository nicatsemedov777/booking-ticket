package com.booking.ticket.service.impl;

import com.booking.ticket.dao.PersonDao;
import com.booking.ticket.dao.impl.PersonDaoImpl;
import com.booking.ticket.model.Flight;
import com.booking.ticket.model.Person;
import com.booking.ticket.service.PersonService;

import java.util.List;

public class PersonServiceImpl implements PersonService {
    private final PersonDaoImpl personDao;

    public PersonServiceImpl(PersonDaoImpl personDao) {
        this.personDao = personDao;
    }


    @Override
    public Person getPerson() {
        return personDao.getPerson();
    }

    @Override
    public List<Flight> getMyFlights(int personId) {
        return personDao.getMyFlights(personId);
    }
}
