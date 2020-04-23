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
    private Integer bookingDate;
    @Column(name = "customer")
    private int customer;
    @Column(name = "car")
    private int car;
    @Column(name = "date_from")
    private Integer dateFrom;
    @Column(name = "date_to")
    private Integer dateTo;
    @Column(name = "booking_cost")
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
