package com.example.controller;

import com.example.dto.CarRentalDTO;
import com.example.service.CarRentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest/CarRental")
public class CarRentalController {

    private final CarRentalService carRentalService;

    public CarRentalController(CarRentalService carRentalService) {
        this.carRentalService = carRentalService;
    }


    @GetMapping("/carRentals")
    public List<CarRentalDTO> getAllCarRentals() {
        return carRentalService.getAllCarRentals();
    }


    @PostMapping("/carRental")
    public void createCarRental(@RequestBody CarRentalDTO carRentalDTO) {
        carRentalService.createCarRental(carRentalDTO);
    }

    @PutMapping("/carRental")
    public void updateCarRental(@RequestBody CarRentalDTO carRentalDTO){
        carRentalService.updateCarRental(carRentalDTO);
    }

    @GetMapping("/CarRental({id})")
    public CarRentalDTO getCarRentalById(@PathVariable Long id) {
        return carRentalService.getCarRentalById(id);
    }
}


