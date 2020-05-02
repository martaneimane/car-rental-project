package com.example.controller;

import com.example.dto.CarReturnDTO;
import com.example.service.CarReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest/CarReturn")
public class CarReturnController {
    private final CarReturnService carReturnService;

    @Autowired
    public CarReturnController(CarReturnService carReturnService) {
        this.carReturnService = carReturnService;
    }


    @GetMapping("/carsReturn")
    public List<CarReturnDTO> getAllCarsReturn() {
        return carReturnService.getAllCarsReturn();
    }


    @PostMapping("/carReturn")
    public void createcarReturn(@RequestBody CarReturnDTO carReturnDTO) {
        carReturnService.createCarReturn(carReturnDTO);
    }

    @PutMapping("/carReturn")
    public void updateBooking(@RequestBody CarReturnDTO carReturnDTO){
        carReturnService.updateCarReturn(carReturnDTO);
    }

    @GetMapping("/carReturn({id})")
    public CarReturnDTO getCarReturnById(@PathVariable Long id) {
        return carReturnService.getCarReturnById(id);
    }
}

