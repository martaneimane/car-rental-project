package com.example.dto.mapper;

import com.example.dto.CarDTO;
import com.example.model.Car;

import org.springframework.stereotype.Service;

@Service
public class CarMapper {

    public CarDTO carsToDto(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setBrand(car.getBrand());
        carDTO.setModel(car.getModel());
        carDTO.setBodyType(car.getBodyType());
        carDTO.setYear(car.getYear());
        carDTO.setColor(car.getColor());
        carDTO.setMileage(car.getMileage());
        carDTO.setStatus(car.getStatus());
        carDTO.setPricePerDay(car.getPricePerDay());
        return carDTO;
    }

    public Car fromDto(CarDTO carDTO) {
        Car car = new Car();
        car.setId(carDTO.getId());
        car.setBrand(carDTO.getBrand());
        car.setModel(carDTO.getModel());
        car.setBodyType(carDTO.getBodyType());
        car.setYear(carDTO.getYear());
        car.setColor(carDTO.getColor());
        car.setMileage(carDTO.getMileage());
        car.setStatus(carDTO.getStatus());
        car.setPricePerDay(carDTO.getPricePerDay());
        return car;
    }
}
