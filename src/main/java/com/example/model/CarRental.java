package com.example.model;

import com.example.dto.BookingDTO;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "car_rental")
public class CarRental implements Serializable {

    @Id
    @GeneratedValue(generator = "SEQUENCE_GENERATOR", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "SEQ_CAR_RENTAL", allocationSize = 1)
    private Long id;
    @ManyToOne(targetEntity = Employee.class)
    private Employee employee;
    @Column(name = "rental_date")
    private LocalDate rentalDate;
    @JsonView(BookingDTO.class)
    @OneToOne(targetEntity = Booking.class)
    private Booking booking;
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

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
