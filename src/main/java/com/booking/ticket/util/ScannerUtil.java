package com.booking.ticket.util;

import com.booking.ticket.model.FlightDto;
import com.booking.ticket.model.Person;

import java.sql.Timestamp;
import java.util.Scanner;

public class ScannerUtil {
    public static FlightDto getFlightDto(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter you destination :");
        String destination = scanner.nextLine();
        System.out.println("Enter the departure time :");
        Timestamp date = Timestamp.valueOf(scanner.nextLine());
        System.out.println("Enter the seats :");
        int seats = scanner.nextInt();
        return new FlightDto(seats,destination,date);


    }
    public static Person getPersonInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name :");
        String name = sc.nextLine();
        System.out.println("Enter your surname :");
        String surname = sc.nextLine();
        return new Person(name,surname);
    }
    public static int getBookingId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your booking id :");
        return scanner.nextInt();
    }
    public static int getPersonId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your id :");
        return scanner.nextInt();
    }
    public static String getDepartureCity(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your departureCity :");
        return sc.nextLine();
    }
    public static String getFlightNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter flight number :");
        return scanner.nextLine();
    }
}
