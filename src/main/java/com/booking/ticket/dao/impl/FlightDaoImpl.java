package com.booking.ticket.dao.impl;

import com.booking.ticket.dao.FlightDao;
import com.booking.ticket.db.ConnectionSql;
import com.booking.ticket.model.Flight;
import com.booking.ticket.model.FlightDto;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class FlightDaoImpl implements FlightDao {

    @Override
    public Flight getFlightsByFlightNumber(String flightNumber) {
        Flight flight;

        try (Connection connection = ConnectionSql.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from flight where flightNumber=?");
            preparedStatement.setString(1, flightNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            flight = getFlight(resultSet);
            return flight;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Flight> getALlFlightsFromOneOfCity(String departureCity) {
        List<Flight> flights;

        try (Connection connection = ConnectionSql.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM flight WHERE departureCity = ? order by departureCity asc ");
            preparedStatement.setString(1, departureCity);
            ResultSet resultSet = preparedStatement.executeQuery();
            flights = getFlights(resultSet);
            return flights;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    @Override
    public List<Flight> searchTicketForBooking(FlightDto flightDto) {
            return chechFullAndGetFlights(flightDto);
    }


    private List<Flight> getFlights(ResultSet resultSet) {
        List<Flight> flights = new LinkedList<>();
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
    }

    private Flight getFlight(ResultSet resultSet) throws SQLException {
        Flight flight = null;

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

            flight = new Flight(id, flightNumber, airline, destination, departureCity,
                    departureTime, arrivalTime, gate, terminal, status,
                    checkInCounter, boardingTime, seats, fullSeats);
        }
        return flight;
    }

    private List<Flight> chechFullAndGetFlights(FlightDto flightDto) {
        int reserved = flightDto.getSeats();
        try {
            PreparedStatement statement1 = ConnectionSql.getConnection().prepareStatement("Select seats from flight where destination = ?");
            statement1.setString(1, flightDto.getDestination());
            ResultSet resultSet = statement1.executeQuery();
            while (resultSet.next())
                reserved += resultSet.getInt("seats");

            PreparedStatement statement2 = ConnectionSql.getConnection().prepareStatement("SELECT * from flight " +
                    "where ? <= fullseats" +
                    " and destination = ? and departuretime =?");
            statement2.setInt(1, reserved);
            statement2.setString(2,flightDto.getDestination());
            statement2.setTimestamp(3,flightDto.getDate());
            ResultSet resultSet2 = statement2.executeQuery();

            PreparedStatement statement3 = ConnectionSql.getConnection().prepareStatement("UPDATE flight " +
                    "SET seats = ? " +
                    "WHERE destination = ? ;");
            statement3.setInt(1,reserved);
            statement3.setString(2, flightDto.getDestination());
            statement3.execute();

            if(resultSet2 == null)
                return null;

            return getFlights(resultSet2);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
