package com.booking.ticket.exception;

public class CommandNotFoundException extends Exception{

    public void Exception(String message) {
        System.out.println("Not found command "+getMessage());
    }

}
