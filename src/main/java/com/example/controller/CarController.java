package com.example.controller;

import com.example.dto.CarDTO;
import com.example.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest/Car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<CarDTO> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/cars({id})")
    public CarDTO getCarById(@PathVariable Long id) {
        return carService.getCarById(id);

    }

    @PostMapping("/car")
    public void createCar(@RequestBody CarDTO carDTO) {
        carService.createCar(carDTO);
    }

    @PutMapping("/car")
    public void updateCar(@RequestBody CarDTO carDTO) {
        carService.updateCar(carDTO);
    }
}
