package com.example.controller;

import com.example.dto.CustomerDTO;
import com.example.dto.request.CustomerCreateRequestDTO;
import com.example.service.CustomerService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest/Customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers({id})")
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping(value = "/customers", consumes = "application/json")
    public CustomerDTO createCustomer(@RequestBody CustomerCreateRequestDTO customerCreateRequestDTO) {
        System.out.println(ReflectionToStringBuilder.reflectionToString(customerCreateRequestDTO));

        return customerService.createCustomer(customerCreateRequestDTO.getCustomerDTO(),
                customerCreateRequestDTO.getPassHash());
    }

    @PutMapping("/customers")
    public void updateCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(customerDTO);
    }
}
