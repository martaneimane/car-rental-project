package com.example.service;

import com.example.dto.RentalOfficeDTO;
import com.example.dto.mapper.RentalOfficeMapper;
import com.example.model.RentalOffice;
import com.example.repository.RentalOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalOfficeService {

    private final RentalOfficeRepository rentalOfficeRepository;
    private final RentalOfficeMapper rentalOfficeMapper;

    @Autowired
    public RentalOfficeService(RentalOfficeRepository rentalOfficeRepository, RentalOfficeMapper rentalOfficeMapper) {
        this.rentalOfficeRepository = rentalOfficeRepository;
        this.rentalOfficeMapper = rentalOfficeMapper;
    }

    public List<RentalOfficeDTO> getAllRentalOffices() {
        return rentalOfficeRepository.findAll().stream()
                .map(rentalOfficeMapper::rentalOfficeToDTO)
                .collect(Collectors.toList());
    }

    public void createRentalOffice(RentalOfficeDTO rentalOfficeDTO) {
        RentalOffice rentalOffice = rentalOfficeMapper.rentalOfficeFromDTO(rentalOfficeDTO);
        rentalOfficeRepository.save(rentalOffice);
    }

    public void updateRentalOffice(RentalOfficeDTO rentalOfficeDTO) {
        RentalOffice rentalOffice = rentalOfficeMapper.rentalOfficeFromDTO(rentalOfficeDTO);
        rentalOfficeRepository.save(rentalOffice);
    }

    public RentalOfficeDTO getRentalOfficeById(Long id) {
        RentalOffice rentalOffice = rentalOfficeRepository.getOne(id);
        return rentalOfficeMapper.rentalOfficeToDTO(rentalOffice);
    }
}
