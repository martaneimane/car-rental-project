package com.example.service;

import com.example.dto.CarDTO;
import com.example.dto.mapper.CarMapper;
import com.example.model.Car;
import com.example.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public CarService(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public List<CarDTO> getAllCars() {
        return carRepository.findAll().stream()
                .map(carMapper::carsToDto)
                .collect(Collectors.toList());
    }

    public void createCar(CarDTO carDTO) {
        Car car = carMapper.fromDto(carDTO);
        carRepository.save(car);
    }

    public void updateCar(CarDTO carDTO) {
        Car car = carMapper.fromDto(carDTO);
        carRepository.save(car);
    }

    public CarDTO getCarById(Long id) {
        Car car = carRepository.getOne(id);
        return carMapper.carsToDto(car);

    }

    public void updateCarStatusToRented(Long id) {
        Car car = carRepository.getOne(id);
        car.setStatus("Rented");
        carRepository.save(car);
    }

}
