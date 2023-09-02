package com.booking.ticket.constants;

public enum Commands {
    SHOW_TICKET(1,"Online-board"),
    FLIGHT_INFO(2,"Show the flight info"),
    BOOKING(3,"Search and book a flight"),
    CANCEL(4,"Cancel the booking"),
    MY_FLIGHTS(5,"My flights"),
    EXIT(6,"Exit");

    private int index;
    private final String value;

    Commands(int index,String value) {
        this.index = index;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }

}
