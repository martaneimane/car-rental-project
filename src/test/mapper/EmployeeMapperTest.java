package mapper;

import com.example.dto.EmployeeDTO;
import com.example.dto.mapper.EmployeeMapper;
import com.example.model.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest {

    private EmployeeMapper employeeMapper = new EmployeeMapper();

    @Test
    void employeeToDTO() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Name");
        employee.setSurname("Surname");
        employee.setJobPosition("Manager");

        EmployeeDTO employeeDTO = employeeMapper.employeeToDTO(employee);
        assertEquals(Long.valueOf(1), employeeDTO.getId());
        assertEquals("Name", employeeDTO.getName());
        assertEquals("Surname", employeeDTO.getSurname());
        assertEquals("Manager", employeeDTO.getJobPosition());
    }

    @Test
    void fromDto() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1L);
        employeeDTO.setName("Name");
        employeeDTO.setSurname("Surname");
        employeeDTO.setJobPosition("Manager");

        Employee employee = employeeMapper.fromDto(employeeDTO);
        assertEquals(Long.valueOf(1), employee.getId());
        assertEquals("Name", employee.getName());
        assertEquals("Surname", employee.getSurname());
        assertEquals("Manager", employee.getJobPosition());
    }
}
