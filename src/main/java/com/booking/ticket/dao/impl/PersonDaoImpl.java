package com.booking.ticket.dao.impl;

import com.booking.ticket.dao.PersonDao;
import com.booking.ticket.db.ConnectionSql;
import com.booking.ticket.model.Flight;
import com.booking.ticket.model.Person;
import com.booking.ticket.util.ScannerUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PersonDaoImpl implements PersonDao {
    @Override
    public Person getPerson() {
        Person p = ScannerUtil.getPersonInfo();
        try {
            PreparedStatement statement = ConnectionSql.getConnection().prepareStatement("INSERT INTO person(name,surname) values(?,?)");
            statement.setString(1, p.getName());
            statement.setString(2, p.getSurName());
            statement.execute();
            PreparedStatement statement2 = ConnectionSql.getConnection().prepareStatement("SELECT id from person where name = ?");
            statement2.setString(1, p.getName());
            ResultSet resultSet = statement2.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                p.setId(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    @Override
    public List<Flight> getMyFlights(int personId) {
        try {
            List<Flight> flights = new ArrayList<>();
            PreparedStatement statement = ConnectionSql.getConnection().prepareStatement("Select * FROM flight as f " +
                    "INNER JOIN booking as b " +
                    "ON b.flight_id = f.id " +
                    "WHERE b.person_id = ?");
            statement.setInt(1, personId);
            ResultSet resultSet = statement.executeQuery();
            try {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String flightNumber = resultSet.getString("flightNumber");
                    String airline = resultSet.getString("airline");
                    String destination = resultSet.getString("destination");
                    String departureCity = resultSet.getString("departureCity");
                    Timestamp arrivalTime = resultSet.getTimestamp("arrivalTime");
                    Timestamp departureTime = resultSet.getTimestamp("departureTime");
                    String gate = resultSet.getString("gate");
                    String terminal = resultSet.getString("terminal");
                    String status = resultSet.getString("status");
                    String checkInCounter = resultSet.getString("checkInCounter");
                    Timestamp boardingTime = resultSet.getTimestamp("boardingTime");
                    int seats = resultSet.getInt("seats");
                    int fullSeats = resultSet.getInt("fullSeats");

                    Flight flight = new Flight(id, flightNumber, airline, destination,
                            departureCity, departureTime, arrivalTime, gate, terminal,
                            status, checkInCounter, boardingTime, seats, fullSeats);
                    flights.add(flight);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                throw new RuntimeException();
            }
            return flights;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
