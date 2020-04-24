package com.example.dto.mapper;

import com.example.dto.CarReturnDTO;

import com.example.model.CarReturn;
import org.springframework.stereotype.Service;

@Service
public class CarReturnMapper {

    public CarReturnDTO carReturnToDto(CarReturn carReturn) {
        CarReturnDTO carReturnDTO = new CarReturnDTO();
        carReturnDTO.setId(carReturn.getId());
        carReturnDTO.setEmployee(carReturn.getEmployee());
        carReturnDTO.setReturnDate(carReturn.getReturnDate());
        carReturnDTO.setBooking(carReturn.getBooking());
        carReturnDTO.setAdditionalPayments(carReturn.getAdditionalPayments());
        carReturnDTO.setComments(carReturn.getComments());
        return carReturnDTO;
    }

    public CarReturn fromDto(CarReturnDTO carReturnDTO) {
        CarReturn carReturn = new CarReturn();
        carReturn.setId(carReturnDTO.getId());
        carReturn.setEmployee(carReturnDTO.getEmployee());
        carReturn.setReturnDate(carReturnDTO.getReturnDate());
        carReturn.setBooking(carReturnDTO.getBooking());
        carReturn.setAdditionalPayments(carReturnDTO.getAdditionalPayments());
        carReturn.setComments(carReturnDTO.getComments());
        return carReturn;
    }
}
