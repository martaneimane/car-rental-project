package com.example.service;

import com.example.dto.CustomerDTO;
import com.example.dto.mapper.CustomerMapper;
import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::customerToDto)
                .collect(Collectors.toList());
    }

    public void createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.fromDto(customerDTO);
        customerRepository.save(customer);
    }

    public void updateCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.fromDto(customerDTO);
        customerRepository.save(customer);
    }

    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.getOne(id);
        return customerMapper.customerToDto(customer);
    }
}

