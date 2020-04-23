package com.example.dto;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.sql.Date;

public class CarRentalDTO {
    private Long id;
    private int employee;
    private java.sql.Date rentalDate;
    private int booking;
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

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
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
