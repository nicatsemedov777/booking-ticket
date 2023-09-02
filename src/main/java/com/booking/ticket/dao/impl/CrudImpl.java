package com.booking.ticket.dao.impl;

import com.booking.ticket.db.ConnectionSql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class CrudImpl {
    public void createDb() {
        try (Connection connection = ConnectionSql.getConnection()) {
            String query = "create database booking_ticket";
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void createTable() {
        try (Connection connection = ConnectionSql.getConnection()) {
            String query1 = "CREATE TABLE person(id serial primary key,name varchar(30) not null,surname varchar(30) not null )";
            String query2 = "CREATE TABLE flight(id serial primary key,flightNumber varchar(25),airline varchar(50)," +
                    "destination varchar(50),departureCity varchar(50),departureTime timestamp,arrivalTime timestamp," +
                    "gate varchar(15),terminal varchar(30),status varchar(30),checkInCounter varchar(30),boardingTime timestamp,seats int,fullSeats int )";
            String query3 = "CREATE TABLE booking(id serial primary key,nameOfPassenger varchar(30),surNameOfPassenger varchar(30),person_id int, flight_id int, " +
                    "CONSTRAINT fk_person foreign key(person_id) references person(id)," +
                    "CONSTRAINT fk_flight foreign key(flight_id) references flight(id))";
            Statement statement = connection.createStatement();
            statement.execute(query1);
            statement.execute(query2);
            statement.execute(query3);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
