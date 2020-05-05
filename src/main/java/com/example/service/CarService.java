package com.example.service;

import com.example.dto.BookingDTO;
import com.example.dto.CarDTO;
import com.example.dto.mapper.BookingMapper;
import com.example.dto.mapper.CarMapper;
import com.example.model.Car;
import com.example.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final BookingMapper bookingMapper;

    @Autowired
    public CarService(CarRepository carRepository, CarMapper carMapper, BookingMapper bookingMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
        this.bookingMapper = bookingMapper;
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
//Added method for calculating booking cost
    public BigDecimal calculateBookingCost(BookingDTO bookingDTO) {
        bookingMapper.bookingFromDto(bookingDTO);
        CarDTO carDTO = carMapper.carsToDto(bookingDTO.getCar());
        BigDecimal carPrice = carDTO.getPricePerDay();
        long bookingDays = ChronoUnit.DAYS.between(bookingDTO.getDateFrom(), bookingDTO.getDateTo());
        return carPrice.multiply(BigDecimal.valueOf(bookingDays));
    }

}
