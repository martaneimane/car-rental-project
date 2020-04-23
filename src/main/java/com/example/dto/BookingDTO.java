package com.example.dto;

import java.math.BigDecimal;

public class BookingDTO {

    private Long id;
    private Integer bookingDate;
    private int customer;
    private int car;
    private Integer dateFrom;
    private Integer dateTo;
    private BigDecimal bookingCost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Integer bookingDate) {
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

    public Integer getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Integer dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Integer getDateTo() {
        return dateTo;
    }

    public void setDateTo(Integer dateTo) {
        this.dateTo = dateTo;
    }

    public BigDecimal getBookingCost() {
        return bookingCost;
    }

    public void setBookingCost(BigDecimal bookingCost) {
        this.bookingCost = bookingCost;
    }
}

