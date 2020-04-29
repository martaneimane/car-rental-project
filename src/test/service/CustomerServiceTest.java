package service;

import com.example.dto.CustomerDTO;
import com.example.dto.mapper.CustomerMapper;
import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CustomerServiceTest {

    private CustomerRepository customerRepository = mock(CustomerRepository.class);
    CustomerService customerService = new CustomerService(customerRepository, new CustomerMapper());

    @Test
    void getAllCustomers() {
        List<CustomerDTO> customersBeforeAdd = customerService.getAllCustomers();

        Customer customer = new Customer();
        customer.setId(1L);

        when(customerRepository.findAll()).thenReturn(Collections.singletonList(customer));
        List<CustomerDTO> customersAfterAdd = customerService.getAllCustomers();

        assertEquals(customersAfterAdd.size(), customersBeforeAdd.size() +1);
    }

    @Test
    void createCustomer() {
        List<CustomerDTO> customersBeforeAdd = customerService.getAllCustomers();

        Customer customer = new Customer();
        customer.setId(1L);

        when(customerRepository.findAll()).thenReturn(Collections.singletonList(customer));
        List<CustomerDTO> customersAfterAdd = customerService.getAllCustomers();

        assertEquals(customersAfterAdd.size(), customersBeforeAdd.size() +1);
    }

    @Test
    void updateCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("TestName");

        when(customerRepository.getOne(1L)).thenReturn(customer);
        CustomerDTO customerResult = customerService.getCustomerById(1L);

        customerResult.setName("MyNewName");
        customerService.updateCustomer(customerResult);

        assertEquals("MyNewName",customerResult.getName());

    }

    @Test
    void getCustomerById() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("TestName");

        when(customerRepository.getOne(1L)).thenReturn(customer);
        CustomerDTO customerResult = customerService.getCustomerById(1L);

        assertEquals(Long.valueOf("1"), customerResult.getId());
        assertEquals("TestName", customerResult.getName());
    }
}
