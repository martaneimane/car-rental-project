package com.example.controller;

import com.example.dto.RentalOfficeDTO;
import com.example.service.RentalOfficeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest/RentalOffice")
public class RentalOfficeController {

    private final RentalOfficeService rentalOfficeService;

    public RentalOfficeController(RentalOfficeService rentalOfficeService) {
        this.rentalOfficeService = rentalOfficeService;
    }

    @GetMapping("/rental-offices")
    public List<RentalOfficeDTO> getAllRentalOffices() {
        return rentalOfficeService.getAllRentalOffices();
    }

    @GetMapping("/rental-office({id})")
    public RentalOfficeDTO getRentalOfficeById(@PathVariable Long id) {
        return rentalOfficeService.getRentalOfficeById(id);
    }

    @PostMapping("/rental-office")
    public void createRentalOffice(@RequestBody RentalOfficeDTO rentalOfficeDTO) {
        rentalOfficeService.createRentalOffice(rentalOfficeDTO);
    }

    @PutMapping("/rental-office")
    public void updateRentalOffice(@RequestBody RentalOfficeDTO rentalOfficeDTO) {
        rentalOfficeService.updateRentalOffice(rentalOfficeDTO);
    }
}
