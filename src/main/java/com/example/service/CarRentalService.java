package com.example.service;

import com.example.dto.CarRentalDTO;
import com.example.dto.mapper.CarRentalMapper;
import com.example.model.CarRental;
import com.example.repository.CarRentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarRentalService {

    private final CarRentalRepository carRentalRepository;
    private final CarRentalMapper carRentalMapper;

    @Autowired
    public CarRentalService(CarRentalRepository carRentalRepository, CarRentalMapper carRentalMapper) {
        this.carRentalRepository = carRentalRepository;
        this.carRentalMapper = carRentalMapper;
    }

    public List<CarRentalDTO> getAllCarRentals(){
        return carRentalRepository.findAll().stream()
                .map(carRentalMapper::carRentalToDTO)
                .collect(Collectors.toList());
    }

    public void createCarRental(CarRentalDTO carRentalDTO){
        CarRental carRental = carRentalMapper.fromDto(carRentalDTO);
        carRentalRepository.save(carRental);
    }

    public void updateCarRental(CarRentalDTO carRentalDTO) {
        CarRental carRental = carRentalMapper.fromDto(carRentalDTO);
        carRentalRepository.save(carRental);
    }

    public CarRentalDTO getCarRentalById(Long id){
        CarRental carRental = carRentalRepository.getOne(id);
        return carRentalMapper.carRentalToDTO(carRental);
    }


}
