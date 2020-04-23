package com.example.dto;

import java.math.BigDecimal;

public class BookingDTO {

    private Long id;
    private Integer booking_date;
    private int customer;
    private int car;
    private Integer date_from;
    private Integer date_to;
    private BigDecimal booking_cost;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getBooking_date() {
        return booking_date;
    }
    public void setBooking_date(Integer booking_date) {
        this.booking_date = booking_date;
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
    public Integer getDate_from() {
        return date_from;
    }
    public void setDate_from(Integer date_from) {
        this.date_from = date_from;
    }
    public Integer getDate_to() {
        return date_to;
    }
    public void setDate_to(Integer date_to) {
        this.date_to = date_to;
    }
    public BigDecimal getBooking_cost() {
        return booking_cost;
    }
    public void setBooking_cost(BigDecimal booking_cost) {
        this.booking_cost = booking_cost;
    }
}

