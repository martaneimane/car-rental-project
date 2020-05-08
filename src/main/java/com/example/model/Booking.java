package com.example.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "booking")
public class Booking implements Serializable {

    @Id
    @GeneratedValue(generator = "SEQUENCE_GENERATOR", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "SEQ_BOOKING", allocationSize = 1)
    private Long id;
    @ApiModelProperty(required = true, example = "2020-01-01")
    @Column(name = "booking_date")
    private LocalDate bookingDate;
    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;
    @ManyToOne(targetEntity = Car.class)
    private Car car;
    @ApiModelProperty(required = true, example = "2020-01-01")
    @Column(name = "date_from")
    private LocalDate dateFrom;
    @ApiModelProperty(required = true, example = "2020-01-01")
    @Column(name = "date_to")
    private LocalDate dateTo;
    @Column(name = "booking_cost")
    private BigDecimal bookingCost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public BigDecimal getBookingCost() {
        return bookingCost;
    }

    public void setBookingCost(BigDecimal bookingCost) {
        this.bookingCost = bookingCost;
    }
}
