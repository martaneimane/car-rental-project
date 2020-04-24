package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Entity(name = "car_return")
public class CarReturn implements Serializable {

    @Id
    @GeneratedValue(generator = "SEQUENCE_GENERATOR", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "SEQ_CAR_RETURN", allocationSize = 1)
    private Long id;
    @Column(name = "employee")
    private int employee;
    @Column(name = "return_date")
    private java.sql.Date returnDate;
    @Column(name = "booking")
    private int booking;
    @Column(name = "additional_payments")
    private BigDecimal additionalPayments;
    @Column(name = "comments")
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

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getBooking() {
        return booking;
    }

    public void setBooking(int booking) {
        this.booking = booking;
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
