package com.booking.ticket.model;

import java.sql.Timestamp;

public class FlightDto {

    private int seats;
    private String destination;
    private Timestamp date;

    public FlightDto(int seats, String destination, Timestamp date) {
        this.seats = seats;
        this.destination = destination;
        this.date = date;
    }


    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
