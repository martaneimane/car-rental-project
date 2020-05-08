package com.example.dto;

import com.example.model.Booking;
import com.example.model.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CarReturnDTO {
    private Long id;
    private Employee employee;
    @ApiModelProperty(required = true, example = "2020-01-01")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;
    private Booking booking;
    private BigDecimal additionalPayments;
    private String comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
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
