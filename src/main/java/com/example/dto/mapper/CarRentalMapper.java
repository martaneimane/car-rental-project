package com.example.dto.mapper;

import com.example.dto.CarRentalDTO;
import com.example.model.CarRental;
import org.springframework.stereotype.Service;

@Service
public class CarRentalMapper {
    public CarRentalDTO carRentalToDTO(CarRental carRental) {
        CarRentalDTO carRentalDTO = new CarRentalDTO();
        carRentalDTO.setId(carRental.getId());
        carRentalDTO.setEmployee(carRental.getEmployee());
        carRentalDTO.setRentalDate(carRental.getRentalDate());
        carRentalDTO.setBooking(carRental.getBooking());
        carRentalDTO.setComments(carRental.getComments());
        return carRentalDTO;
    }

    public CarRental fromDto(CarRentalDTO carRentalDTO) {
        CarRental carRental = new CarRental();
        carRental.setId(carRentalDTO.getId());
        carRental.setEmployee(carRentalDTO.getEmployee());
        carRental.setRentalDate(carRentalDTO.getRentalDate());
        carRental.setBooking(carRentalDTO.getBooking());
        carRental.setComments(carRentalDTO.getComments());
        return carRental;
    }
}
