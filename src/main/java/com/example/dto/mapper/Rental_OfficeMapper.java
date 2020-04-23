package com.example.dto.mapper;

import com.example.dto.Rental_OfficeDTO;
import com.example.model.Rental_Office;

public class Rental_OfficeMapper {

    public Rental_OfficeDTO rentalOfficeToDTO (Rental_Office rental_office){
        Rental_OfficeDTO rental_officeDTO = new Rental_OfficeDTO();
        rental_officeDTO.setId(rental_office.getId());
        rental_officeDTO.setAddress(rental_office.getAddress());
        rental_officeDTO.setCars_total(rental_office.getCars_total());
        rental_officeDTO.setEmployees_total(rental_office.getEmployees_total());
        rental_officeDTO.setName(rental_office.getName());
        rental_officeDTO.setWeb_page(rental_office.getWeb_page());
        return rental_officeDTO;
    }

    public Rental_Office rentalOfficeFromDTO (Rental_OfficeDTO rentalOfficeDTO){
        Rental_Office rental_office = new Rental_Office();
        rental_office.setId(rentalOfficeDTO.getId());
        rental_office.setAddress(rentalOfficeDTO.getAddress());
        rental_office.setCars_total(rentalOfficeDTO.getCars_total());
        rental_office.setEmployees_total(rentalOfficeDTO.getEmployees_total());
        rental_office.setName(rentalOfficeDTO.getName());
        rental_office.setWeb_page(rentalOfficeDTO.getWeb_page());
        return rental_office;


    }
}
