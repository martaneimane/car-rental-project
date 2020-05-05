package com.example.dto.mapper;

import com.example.dto.CustomerDTO;
import com.example.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public CustomerDTO customerToDto(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setSurname(customer.getSurname());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setEmail(customer.getEmail());
        return customerDTO;
    }
    public Customer fromDto(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        return customer;
    }
}
