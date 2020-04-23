package com.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Rental implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @Column(name = "EmployeeID")
    private int employee;
    @Column(name = "Rental date")
    private Integer rental_date;
    @Column(name = "BookingID")
    private int booking;
    @Column(name = "Comments")
    private String comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public Integer getRental_date() {
        return rental_date;
    }

    public void setRental_date(Integer rental_date) {
        this.rental_date = rental_date;
    }

    public int getBooking() {
        return booking;
    }

    public void setBooking(int booking) {
        this.booking = booking;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
