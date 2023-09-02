package com.booking.ticket.dao.impl;

import com.booking.ticket.controller.PersonController;
import com.booking.ticket.dao.BookingDao;
import com.booking.ticket.db.ConnectionSql;
import com.booking.ticket.model.Booking;
import com.booking.ticket.model.Flight;
import com.booking.ticket.model.FlightDto;
import com.booking.ticket.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingDaoImpl implements BookingDao {
    @Override
    public void reserveBooking(FlightDto flightDto, Flight flight, PersonController personController) {
        for (int i = 0; i < flightDto.getSeats(); i++) {
            Person person = personController.getPerson();
            Booking booking = new Booking(person.getName(), person.getSurName(), flight, person);
            try {
                PreparedStatement statement = ConnectionSql.getConnection().prepareStatement("INSERT INTO booking(nameofpassenger,surnameofpassenger,person_id,flight_id) " +
                        "VALUES (?,?,?,?)");
                statement.setString(1, booking.getNameOfPassenger());
                statement.setString(2, booking.getSurNameOfPassenger());
                statement.setInt(3, booking.getPerson().getId());
                statement.setInt(4, booking.getFlight().getId());
                statement.execute();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void cancelBooking(int bookingNumber) {
        try {
            PreparedStatement firstStatement = ConnectionSql.getConnection().prepareStatement("SELECT person_id, flight_id " +
                    "FROM booking " +
                    "WHERE id = ? ;");
            firstStatement.setInt(1, bookingNumber);
            ResultSet resultSet = firstStatement.executeQuery();
            PreparedStatement statement = ConnectionSql.getConnection().prepareStatement("Delete from booking where id = ?");
            statement.setInt(1, bookingNumber);
            statement.execute();

            updateTables(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateTables(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                int personId = resultSet.getInt("person_id");
                deletePerson(personId);
                int flightId = resultSet.getInt("flight_id");

                PreparedStatement statement = ConnectionSql.getConnection().prepareStatement("Update flight " +
                        "SET seats = seats-1 " +
                        "WHERE id = ?");
                statement.setInt(1, flightId);
                statement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void deletePerson(int personId) {
        try {
            PreparedStatement statement = ConnectionSql.getConnection().prepareStatement("Delete from person " +
                    "WHERE id = ?");
            statement.setInt(1, personId);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

