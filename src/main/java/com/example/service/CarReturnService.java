package com.example.service;

import com.example.dto.CarReturnDTO;
import com.example.dto.EmployeeDTO;
import com.example.dto.mapper.CarReturnMapper;
import com.example.dto.mapper.EmployeeMapper;
import com.example.model.Car;
import com.example.model.CarReturn;
import com.example.repository.CarReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarReturnService {

    private final CarReturnRepository carReturnRepository;
    private final CarReturnMapper carReturnMapper;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private CarService carService;

    @Autowired
    public CarReturnService(CarReturnRepository carReturnRepository, CarReturnMapper carReturnMapper) {
        this.carReturnRepository = carReturnRepository;
        this.carReturnMapper = carReturnMapper;
    }


    public List<CarReturnDTO> getAllCarsReturn() {
        return carReturnRepository.findAll().stream()
                .map(carReturnMapper::carReturnToDto)
                .collect(Collectors.toList());
    }

    public void createCarReturn(CarReturnDTO carReturnDTO) {
        CarReturn carReturn = carReturnMapper.fromDto(carReturnDTO);
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(3L);
        carReturn.setEmployee(employeeMapper.fromDto(employeeDTO));
        Car car = carReturn.getBooking().getCar();
        if (carReturn.getReturnDate().isEqual(LocalDate.now())) {
            carService.updateCarStatusToAvailable(car.getId());
        }
        carReturn.setComments("Add comments if necessary.");
        carReturn.setAdditionalPayments(BigDecimal.valueOf(0L));
        carReturnRepository.save(carReturn);
    }

    public void updateCarReturn(CarReturnDTO carReturnDTO) {
        CarReturn carReturn = carReturnMapper.fromDto(carReturnDTO);
        carReturnRepository.save(carReturn);
    }

    public CarReturnDTO getCarReturnById(Long id) {
        CarReturn carReturn = carReturnRepository.getOne(id);
        return carReturnMapper.carReturnToDto(carReturn);
    }


}
