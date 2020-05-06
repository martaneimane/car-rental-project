package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerDTO {

    private Long id;
    private String name;
    private String surname;
    private String address;
    private String email;
    @JsonProperty("customer_hash")
    private String customerHash;




    public String getCustomerHash() {
        return customerHash;
    }

    public void setCustomerHash(String customerHash) {
        this.customerHash = customerHash;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
