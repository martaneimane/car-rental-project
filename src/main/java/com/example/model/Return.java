package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Return implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @Column(name = "EmployeeID")
    private int employee;
    @Column(name = "Return date")
    private Integer return_date;
    @Column(name = "BookingID")
    private int booking;
    @Column(name = "Additional payements")
    private BigDecimal add_payments;
    @Column(name = "Comments")
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

    public Integer getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Integer return_date) {
        this.return_date = return_date;
    }

    public int getBooking() {
        return booking;
    }

    public void setBooking(int booking) {
        this.booking = booking;
    }

    public BigDecimal getAdd_payments() {
        return add_payments;
    }

    public void setAdd_payments(BigDecimal add_payments) {
        this.add_payments = add_payments;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
