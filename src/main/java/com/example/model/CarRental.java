package com.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "car_rental")
public class CarRental implements Serializable {

    @Id
    @GeneratedValue(generator = "SEQUENCE_GENERATOR", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "SEQ_CAR_RENTAL", allocationSize = 1)
    private Long id;
    @Column(name = "employee")
    private int employee;
    @Column(name = "rental_date")
    private Integer rentalDate;
    @Column(name = "booking")
    private int booking;
    @Column(name = "comments")
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

    public Integer getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Integer rentalDate) {
        this.rentalDate = rentalDate;
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
