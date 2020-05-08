package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "car_return")
public class CarReturn implements Serializable {

    @Id
    @GeneratedValue(generator = "SEQUENCE_GENERATOR", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "SEQ_CAR_RETURN", allocationSize = 1)
    private Long id;
    @ManyToOne(targetEntity = Employee.class)
    private Employee employee;
    @Column(name = "return_date")
    private LocalDate returnDate;
    @OneToOne(targetEntity = Booking.class)
    private Booking booking;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
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
