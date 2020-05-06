package com.example.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthRequestDTO {

    private String email;

    @JsonProperty("crypted_token")
    private String cryptedToken;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCryptedToken() {
        return cryptedToken;
    }

    public void setCryptedToken(String cryptedToken) {
        this.cryptedToken = cryptedToken;
    }
}
