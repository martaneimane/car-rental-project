package com.example.dto;

import javax.persistence.Column;
import java.math.BigDecimal;

public class CarReturnDTO {
    private Long id;
    private int employee;
    private Integer returnDate;
    private int booking;
    private BigDecimal additionalPayments;
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


    public int getBooking() {
        return booking;
    }

    public void setBooking(int booking) {
        this.booking = booking;
    }

    public Integer getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Integer returnDate) {
        this.returnDate = returnDate;
    }

    public BigDecimal getAdditionalPayments() {
        return additionalPayments;
    }

    public void setAdditionalPayments(BigDecimal additionalPayments) {
        this.additionalPayments = additionalPayments;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
