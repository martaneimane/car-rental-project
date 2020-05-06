package com.example.dto;

public class AuthTockenResponse extends AbstractResponseDTO {

    private String customerName;
    private String token;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
