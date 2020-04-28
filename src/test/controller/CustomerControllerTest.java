package controller;

import com.example.Application;
import com.example.controller.CustomerController;
import com.example.dto.CustomerDTO;
import com.example.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
@ContextConfiguration(classes = Application.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getAllCustomers() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1L);
        customerDTO.setName("Customer name");
        customerDTO.setSurname("Customer surname");
        customerDTO.setAddress("Customer address");
        customerDTO.setEmail("customer@example.com");

        List<CustomerDTO> allCustomers = Collections.singletonList(customerDTO);

        given(customerService.getAllCustomers()).willReturn(allCustomers);

        mvc.perform(get("/api/v1/rest/Customer/customers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(objectMapper.writeValueAsString(allCustomers))));
    }

    @Test
    void getCustomerById() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1L);
        customerDTO.setName("Customer name");
        customerDTO.setSurname("Customer surname");
        customerDTO.setAddress("Customer address");
        customerDTO.setEmail("customer@example.com");

        given(customerService.getCustomerById(1L)).willReturn(customerDTO);

        mvc.perform(get("/api/v1/rest/Customer/customers(1)")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(objectMapper.writeValueAsString(customerDTO))));

    }

    @Test
    void createCustomer() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1L);
        customerDTO.setName("Customer name");
        customerDTO.setSurname("Customer surname");
        customerDTO.setAddress("Customer address");
        customerDTO.setEmail("customer@example.com");

        mvc.perform(post("/api/v1/rest/Customer/customer")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customerDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    void updateCustomer() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1L);
        customerDTO.setName("Customer name");
        customerDTO.setSurname("Customer surname");
        customerDTO.setAddress("Customer address");
        customerDTO.setEmail("customer@example.com");

        mvc.perform(put("/api/v1/rest/Customer/customer")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customerDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }
}
