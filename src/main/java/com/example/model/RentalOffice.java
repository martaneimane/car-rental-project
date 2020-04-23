package com.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "rental_office")
public class RentalOffice implements Serializable {

    @Id
    @GeneratedValue(generator = "SEQUENCE_GENERATOR", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "SEQ_RENTALOFFICE", allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "web_page")
    private String webPage;
    @Column(name = "cars_total")
    private Integer carsTotal;
    @Column(name = "employees_total")
    private Integer employeesTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public Integer getCarsTotal() {
        return carsTotal;
    }

    public void setCarsTotal(Integer carsTotal) {
        this.carsTotal = carsTotal;
    }

    public Integer getEmployeesTotal() {
        return employeesTotal;
    }

    public void setEmployeesTotal(Integer employeesTotal) {
        this.employeesTotal = employeesTotal;
    }
}
