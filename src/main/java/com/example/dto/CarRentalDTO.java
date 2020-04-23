package com.example.dto;

import javax.persistence.Column;
import java.math.BigDecimal;

public class CarRentalDTO {
    private Long id;
    private int employee;
    private Integer rentalDate;
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
