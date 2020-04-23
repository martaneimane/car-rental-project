package com.example.service;

import com.example.dto.EmployeeDTO;
import com.example.dto.mapper.EmployeeMapper;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public List<EmployeeDTO> getAllEmployees(){
        return employeeRepository.findAll().stream()
                .map(employeeMapper::employeeToDTO)
                .collect(Collectors.toList());
    }

   public void createEmployee(EmployeeDTO employeeDTO){
       Employee employee = employeeMapper.fromDto(employeeDTO);
       employeeRepository.save(employee);
   }

   public void updateEmployee(EmployeeDTO employeeDTO){
        Employee employee = employeeMapper.fromDto(employeeDTO);
        employeeRepository.save(employee);
   }

   public EmployeeDTO getEmployeeById(Long id){
        Employee employee = employeeRepository.getOne(id);
        return employeeMapper.employeeToDTO(employee);
   }
}
