package com.booking.ticket.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {
    private Long id;
    private String nameOfPassenger;
    private String surNameOfPassenger;
    private Flight flight;
    private Person person;

    public Booking( String nameOfPassenger, String surNameOfPassenger, Flight flight, Person person) {
        this.nameOfPassenger = nameOfPassenger;
        this.surNameOfPassenger = surNameOfPassenger;
        this.flight = flight;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfPassenger() {
        return nameOfPassenger;
    }

    public void setNameOfPassenger(String nameOfPassenger) {
        this.nameOfPassenger = nameOfPassenger;
    }

    public String getSurNameOfPassenger() {
        return surNameOfPassenger;
    }

    public void setSurNameOfPassenger(String surNameOfPassenger) {
        this.surNameOfPassenger = surNameOfPassenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", nameOfPassenger='" + nameOfPassenger + '\'' +
                ", surNameOfPassenger='" + surNameOfPassenger + '\'' +
                ", flight=" + flight +
                ", person=" + person +
                '}';
    }
}
