package service;


import com.example.dto.RentalOfficeDTO;
import com.example.dto.mapper.RentalOfficeMapper;
import com.example.model.RentalOffice;
import com.example.repository.RentalOfficeRepository;
import com.example.service.RentalOfficeService;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RentalOfficeServiceTest {

    private RentalOfficeRepository rentalOfficeRepository = mock(RentalOfficeRepository.class);
    RentalOfficeService rentalOfficeService = new RentalOfficeService(rentalOfficeRepository, new RentalOfficeMapper());

    @Test
    void getAllRentalOffices() {
        List<RentalOfficeDTO> rentalOfficeBeforeAdd = rentalOfficeService.getAllRentalOffices();

        RentalOffice rentalOffice = new RentalOffice();
        rentalOffice.setId(1L);

        when(rentalOfficeRepository.findAll()).thenReturn(Collections.singletonList(rentalOffice));
        List<RentalOfficeDTO> rentalOfficeAfterAdd = rentalOfficeService.getAllRentalOffices();

        assertEquals(rentalOfficeAfterAdd.size(), rentalOfficeBeforeAdd.size() +1);
    }

    @Test
    void createRentalOffice() {
        List<RentalOfficeDTO> rentalOfficeBeforeAdd = rentalOfficeService.getAllRentalOffices();

        RentalOffice rentalOffice = new RentalOffice();
        rentalOffice.setId(1L);

        when(rentalOfficeRepository.findAll()).thenReturn(Collections.singletonList(rentalOffice));
        List<RentalOfficeDTO> rentalOfficeAfterAdd = rentalOfficeService.getAllRentalOffices();

        assertEquals(rentalOfficeAfterAdd.size(), rentalOfficeBeforeAdd.size() +1);
    }

    @Test
    void updateRentalOffice() {
        RentalOffice rentalOffice = new RentalOffice();
        rentalOffice.setId(1L);
        rentalOffice.setName("TestName");

        when(rentalOfficeRepository.getOne(1L)).thenReturn(rentalOffice);
        RentalOfficeDTO rentalOfficeResult = rentalOfficeService.getRentalOfficeById(1L);

        rentalOfficeResult.setName("MyNewName");
        rentalOfficeService.updateRentalOffice(rentalOfficeResult);

        assertEquals("MyNewName",rentalOfficeResult.getName());
    }

    @Test
    void getRentalOfficeById() {
        RentalOffice rentalOffice = new RentalOffice();
        rentalOffice.setId(1L);
        rentalOffice.setName("TestName");

        when(rentalOfficeRepository.getOne(1L)).thenReturn(rentalOffice);
        RentalOfficeDTO rentalOfficeResult = rentalOfficeService.getRentalOfficeById(1L);

        assertEquals(Long.valueOf("1"), rentalOfficeResult.getId());
        assertEquals("TestName", rentalOfficeResult.getName());
    }
}
