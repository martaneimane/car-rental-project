package com.example.dto;

public class AuthTockenResponse extends AbstractResponseDTO {

    private String customerEmail;
    private String token;

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
