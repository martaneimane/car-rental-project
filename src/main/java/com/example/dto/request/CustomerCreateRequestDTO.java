package com.example.dto.request;

import com.example.dto.CustomerDTO;
import com.example.model.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("")
public class CustomerCreateRequestDTO {
    @JsonProperty("customer_dto")
    private CustomerDTO customerDTO;
    @JsonProperty("password_hash")
    private String passHash;

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }
}
