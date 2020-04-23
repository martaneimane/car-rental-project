package com.example.dto.mapper;

import com.example.dto.RentalOfficeDTO;
import com.example.model.RentalOffice;
import org.springframework.stereotype.Service;

@Service
public class RentalOfficeMapper {

    public RentalOfficeDTO rentalOfficeToDTO (RentalOffice rentalOffice){
        RentalOfficeDTO rentalOfficeDTO = new RentalOfficeDTO();
        rentalOfficeDTO.setId(rentalOffice.getId());
        rentalOfficeDTO.setAddress(rentalOffice.getAddress());
        rentalOfficeDTO.setCarsTotal(rentalOffice.getCarsTotal());
        rentalOfficeDTO.setEmployeesTotal(rentalOffice.getEmployeesTotal());
        rentalOfficeDTO.setName(rentalOffice.getName());
        rentalOfficeDTO.setWebPage(rentalOffice.getWebPage());
        return rentalOfficeDTO;
    }

    public RentalOffice rentalOfficeFromDTO (RentalOfficeDTO rentalOfficeDTO){
        RentalOffice rentalOffice = new RentalOffice();
        rentalOffice.setId(rentalOfficeDTO.getId());
        rentalOffice.setAddress(rentalOfficeDTO.getAddress());
        rentalOffice.setCarsTotal(rentalOfficeDTO.getCarsTotal());
        rentalOffice.setEmployeesTotal(rentalOfficeDTO.getEmployeesTotal());
        rentalOffice.setName(rentalOfficeDTO.getName());
        rentalOffice.setWebPage(rentalOfficeDTO.getWebPage());
        return rentalOffice;

    }
}
