package com.example.service;

import com.example.dto.CarRentalDTO;
import com.example.dto.EmployeeDTO;
import com.example.dto.mapper.CarRentalMapper;
import com.example.dto.mapper.EmployeeMapper;
import com.example.model.Car;
import com.example.model.CarRental;
import com.example.repository.CarRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarRentalService {

    private final CarRentalRepository carRentalRepository;
    private final CarRentalMapper carRentalMapper;

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private CarService carService;

    @Autowired
    public CarRentalService(CarRentalRepository carRentalRepository, CarRentalMapper carRentalMapper) {
        this.carRentalRepository = carRentalRepository;
        this.carRentalMapper = carRentalMapper;
    }

    public List<CarRentalDTO> getAllCarRentals() {
        return carRentalRepository.findAll().stream()
                .map(carRentalMapper::carRentalToDTO)
                .collect(Collectors.toList());
    }

    public void createCarRental(CarRentalDTO carRentalDTO) {
        CarRental carRental = carRentalMapper.fromDto(carRentalDTO);
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(2L);
        carRental.setEmployee(employeeMapper.fromDto(employeeDTO));
        Car car = carRental.getBooking().getCar();
        if (carRental.getRentalDate().isEqual(LocalDate.now())) {
            carService.updateCarStatusToRented(car.getId());
        }
        carRental.setComments("Add comments if necessary");
        carRentalRepository.save(carRental);
    }

    public void updateCarRental(CarRentalDTO carRentalDTO) {
        CarRental carRental = carRentalMapper.fromDto(carRentalDTO);
        carRentalRepository.save(carRental);
    }

    public CarRentalDTO getCarRentalById(Long id) {
        CarRental carRental = carRentalRepository.getOne(id);
        return carRentalMapper.carRentalToDTO(carRental);
    }


}
