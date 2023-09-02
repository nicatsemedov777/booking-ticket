package com.booking.ticket;

import com.booking.ticket.constants.Commands;
import com.booking.ticket.controller.BookingController;
import com.booking.ticket.controller.FlightController;
import com.booking.ticket.controller.PersonController;
import com.booking.ticket.dao.FlightDao;
import com.booking.ticket.dao.impl.BookingDaoImpl;
import com.booking.ticket.dao.impl.FlightDaoImpl;
import com.booking.ticket.dao.impl.PersonDaoImpl;
import com.booking.ticket.exception.CommandNotFoundException;
import com.booking.ticket.model.Flight;
import com.booking.ticket.model.FlightDto;
import com.booking.ticket.model.Person;
import com.booking.ticket.service.impl.BookingServiceImpl;
import com.booking.ticket.service.impl.FlightServiceImpl;
import com.booking.ticket.service.impl.PersonServiceImpl;
import com.booking.ticket.util.ScannerUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OnlineBoard implements Runnable {
    private final PersonController personController = new PersonController(new PersonServiceImpl(new PersonDaoImpl()));
    private final FlightController flightController = new FlightController(new FlightServiceImpl(new FlightDaoImpl()));
    private final BookingController bookingController = new BookingController(new BookingServiceImpl(new BookingDaoImpl()));

    public OnlineBoard() {
    }
    public void run() {


        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            showCommands();
            int command = sc.nextInt();
            switch (command) {
                case 1 -> System.out.println(flightController.getAllFlightsFromOneOfCity(ScannerUtil.getDepartureCity()));

                case 2 -> System.out.println(flightController.getFlightsByFlightNumber(ScannerUtil.getFlightNumber()));

               case 3->{
                   FlightDto flightDto = ScannerUtil.getFlightDto();
                   List<Flight> flights = flightController.searchTicketForBooking(flightDto);
                   bookingController.reserveBooking( flightDto,flights.get(0),personController);
               }

                case 4-> bookingController.cancelBooking(ScannerUtil.getBookingId());

                case 5-> personController.getMyFlights(ScannerUtil.getPersonId()).forEach(System.out::println);

                case 6-> flag = false;

                default -> {
                    CommandNotFoundException commandNotFoundException=new CommandNotFoundException();
                    commandNotFoundException.Exception("try again");
                }
            }
        }
    }

    private void showCommands() {
        Arrays.stream(Commands.values())
                .forEach(it -> System.out.printf("%d - %s - %s \n", it.getIndex(),it, it.getValue()));
    }
}
