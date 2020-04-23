package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class BookingDTO {

    private Long id;
    private java.sql.Date bookingDate;
    private int customer;
    private int car;
    private java.sql.Date dateFrom;
    private java.sql.Date dateTo;
    private BigDecimal bookingCost;

    @JsonProperty("booking_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.sql.Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(java.sql.Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getCar() {
        return car;
    }

    public void setCar(int car) {
        this.car = car;
    }

    public java.sql.Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(java.sql.Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public java.sql.Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(java.sql.Date dateTo) {
        this.dateTo = dateTo;
    }

    public BigDecimal getBookingCost() {
        return bookingCost;
    }

    public void setBookingCost(BigDecimal bookingCost) {
        this.bookingCost = bookingCost;
    }
}

