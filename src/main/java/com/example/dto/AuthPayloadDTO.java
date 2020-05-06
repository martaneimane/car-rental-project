package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthPayloadDTO {
    @JsonProperty("customer_email")
    private String customerEmail;
    private String password;

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
