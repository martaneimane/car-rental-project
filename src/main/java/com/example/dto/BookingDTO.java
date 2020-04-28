package com.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookingDTO {


    @JsonProperty("booking_id")
    private Long id;
    @ApiModelProperty(required = true, example = "2020-01-01")
    @JsonProperty("bookingDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate bookingDate;
    @JsonProperty("customer")
    private int customer;
    @JsonProperty("car")
    private int car;
    @ApiModelProperty(required = true, example = "2020-01-01")
    @JsonProperty("dateFrom")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFrom;
    @JsonProperty("dateTo")
    @ApiModelProperty(required = true, example = "2020-01-01")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateTo;
    @JsonProperty("bookingCost")
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

