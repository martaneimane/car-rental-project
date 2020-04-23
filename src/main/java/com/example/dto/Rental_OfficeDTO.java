package com.example.dto;

public class Rental_OfficeDTO extends AbstractResponseDTO{


    private Long id;
    private String name;
    private String address;
    private String web_page;
    private Integer cars_total;
    private Integer employees_total;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public String getWeb_page() {
        return web_page;
    }

    public void setWeb_page(String web_page) {
        this.web_page = web_page;
    }

    public Integer getCars_total() {
        return cars_total;
    }

    public void setCars_total(Integer cars_total) {
        this.cars_total = cars_total;
    }

    public Integer getEmployees_total() {
        return employees_total;
    }

    public void setEmployees_total(Integer employees_total) {
        this.employees_total = employees_total;
    }
}


