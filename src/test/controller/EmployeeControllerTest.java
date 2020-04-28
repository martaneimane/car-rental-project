package controller;

import com.example.Application;
import com.example.controller.EmployeeController;
import com.example.dto.EmployeeDTO;
import com.example.service.EmployeeService;
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
@WebMvcTest(EmployeeController.class)
@ContextConfiguration(classes = Application.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeService employeeService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getAllEmployees() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1L);
        employeeDTO.setName("Employee name");
        employeeDTO.setSurname("Employee surname");
        employeeDTO.setJobPosition("Manager");

        List<EmployeeDTO> allEmployees = Collections.singletonList(employeeDTO);

        given(employeeService.getAllEmployees()).willReturn(allEmployees);

        mvc.perform(get("/api/v1/rest/Employee/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(objectMapper.writeValueAsString(allEmployees))));
    }

    @Test
    void getEmployeeById() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1L);
        employeeDTO.setName("Employee name");
        employeeDTO.setSurname("Employee surname");
        employeeDTO.setJobPosition("Manager");

        given(employeeService.getEmployeeById(1L)).willReturn(employeeDTO);

        mvc.perform(get("/api/v1/rest/Employee/employees(1)")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(objectMapper.writeValueAsString(employeeDTO))));

    }

    @Test
    void createEmployee() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1L);
        employeeDTO.setName("Employee name");
        employeeDTO.setSurname("Employee surname");
        employeeDTO.setJobPosition("Manager");

        mvc.perform(post("/api/v1/rest/Employee/employee")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

    }

    @Test
    void updateEmployee() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1L);
        employeeDTO.setName("Employee name");
        employeeDTO.setSurname("Employee surname");
        employeeDTO.setJobPosition("Manager");

        mvc.perform(put("/api/v1/rest/Employee/employee")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employeeDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }
}
