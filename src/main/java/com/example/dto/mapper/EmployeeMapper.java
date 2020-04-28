package com.example.dto.mapper;

import com.example.dto.EmployeeDTO;
import com.example.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {
    public EmployeeDTO employeeToDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSurname(employee.getSurname());
        employeeDTO.setJobPosition(employee.getJobPosition());
        return employeeDTO;
    }
    public Employee fromDto(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.setJobPosition(employeeDTO.getJobPosition());
        return employee;
    }
}
