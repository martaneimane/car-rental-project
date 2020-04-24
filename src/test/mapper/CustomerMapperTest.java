package mapper;

import com.example.dto.CustomerDTO;
import com.example.dto.mapper.CustomerMapper;
import com.example.model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {

    private CustomerMapper customerMapper = new CustomerMapper();

    @Test
    void customerToDto() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Name");
        customer.setSurname("Surname");
        customer.setEmail("example@email.com");
        customer.setAddress("Address");

        CustomerDTO customerDTO = customerMapper.customerToDto(customer);
        assertEquals(Long.valueOf(1), customerDTO.getId());
        assertEquals("Name", customerDTO.getName());
        assertEquals("Surname", customerDTO.getSurname());
        assertEquals("example@email.com", customerDTO.getEmail());
        assertEquals("Address", customerDTO.getAddress());

    }

    @Test
    void fromDto() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1L);
        customerDTO.setName("Name");
        customerDTO.setSurname("Surname");
        customerDTO.setEmail("example@email.com");
        customerDTO.setAddress("Address");

        Customer customer = customerMapper.fromDto(customerDTO);
        assertEquals(Long.valueOf(1), customer.getId());
        assertEquals("Name", customer.getName());
        assertEquals("Surname", customer.getSurname());
        assertEquals("example@email.com", customer.getEmail());
        assertEquals("Address", customer.getAddress());
    }
}
