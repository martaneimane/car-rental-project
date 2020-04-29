package service;

import com.example.dto.EmployeeDTO;
import com.example.dto.mapper.EmployeeMapper;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeeServiceTest {

    private EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
    EmployeeService employeeService = new EmployeeService(employeeRepository, new EmployeeMapper());

    @Test
    void getAllEmployees() {
        List<EmployeeDTO> employeesBeforeAdd = employeeService.getAllEmployees();

        Employee employee = new Employee();
        employee.setId(1L);

        when(employeeRepository.findAll()).thenReturn(Collections.singletonList(employee));
        List<EmployeeDTO> employeeAfterAdd = employeeService.getAllEmployees();

        assertEquals(employeeAfterAdd.size(), employeesBeforeAdd.size() +1);
    }

    @Test
    void createEmployee() {
        List<EmployeeDTO> employeesBeforeAdd = employeeService.getAllEmployees();

        Employee employee = new Employee();
        employee.setId(1L);

        when(employeeRepository.findAll()).thenReturn(Collections.singletonList(employee));
        List<EmployeeDTO> employeeAfterAdd = employeeService.getAllEmployees();

        assertEquals(employeeAfterAdd.size(), employeesBeforeAdd.size() +1);
    }

    @Test
    void updateEmployee() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("TestName");

        when(employeeRepository.getOne(1L)).thenReturn(employee);
        EmployeeDTO employeeResult = employeeService.getEmployeeById(1L);

        employeeResult.setName("MyNewName");
        employeeService.updateEmployee(employeeResult);

        assertEquals("MyNewName",employeeResult.getName());
    }

    @Test
    void getEmployeeById() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("TestName");

        when(employeeRepository.getOne(1L)).thenReturn(employee);
        EmployeeDTO employeeResult = employeeService.getEmployeeById(1L);

        assertEquals(Long.valueOf("1"), employeeResult.getId());
        assertEquals("TestName", employeeResult.getName());
    }
}
