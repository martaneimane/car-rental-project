package com.example.service;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final CustomerRepository customerRepository;

    @Autowired
    public AuthService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerPassword(String email) {
        Customer customer = customerRepository.findByEmail(email);
        if (customer == null) {
            throw new ServiceException("NEED TO MAKE ERROR");
        }
        return customer.getPassword();
    }
}
