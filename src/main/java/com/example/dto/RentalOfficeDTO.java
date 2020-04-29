package com.example.dto;

public class RentalOfficeDTO {


    private Long id;
    private String name;
    private String address;
    private String webPage;
    private Integer carsTotal;
    private Integer employeesTotal;

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


