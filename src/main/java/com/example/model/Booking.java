package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name = "booking")
public class Booking implements Serializable {

    @Id
    @GeneratedValue(generator = "SEQUENCE_GENERATOR", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "SEQ_BOOKING", allocationSize = 1)
    private Long id;
    @Column(name = "booking_date")
    private java.sql.Date bookingDate;
    @Column(name = "customer")
    private int customer;
    @Column(name = "car")
    private int car;
    @Column(name = "date_from")
    private java.sql.Date dateFrom;
    @Column(name = "date_to")
    private java.sql.Date dateTo;
    @Column(name = "booking_cost")
    private BigDecimal bookingCost;

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
