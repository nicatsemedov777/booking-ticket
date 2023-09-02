package com.booking.ticket.model;

import java.util.List;

public class Person {
    private int id;
    private String name;
    private String surName;
    private List<Booking> bookList;

    public Person( String name, String surName, List<Booking> bookList) {
        this.name = name;
        this.surName = surName;
        this.bookList = bookList;
    }

    public Person(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public List<Booking> getBookList() {
        return bookList;
    }

    public void setBookList(List<Booking> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
