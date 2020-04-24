package mapper;

import com.example.dto.RentalOfficeDTO;
import com.example.dto.mapper.RentalOfficeMapper;
import com.example.model.RentalOffice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalOfficeMapperTest {

    private RentalOfficeMapper rentalOfficeMapper = new RentalOfficeMapper();

    @Test
    void rentalOfficeToDTO() {
        RentalOffice rentalOffice = new RentalOffice();
        rentalOffice.setId(1L);
        rentalOffice.setName("Rental Office Name");
        rentalOffice.setAddress("Address");
        rentalOffice.setWebPage("rentaloffice.com");
        rentalOffice.setCarsTotal(10);
        rentalOffice.setEmployeesTotal(5);

        RentalOfficeDTO rentalOfficeDTO = rentalOfficeMapper.rentalOfficeToDTO(rentalOffice);
        assertEquals(Long.valueOf(1), rentalOfficeDTO.getId());
        assertEquals("Rental Office Name", rentalOfficeDTO.getName());
        assertEquals("Address", rentalOfficeDTO.getAddress());
        assertEquals("rentaloffice.com", rentalOfficeDTO.getWebPage());
        assertEquals(10, rentalOfficeDTO.getCarsTotal());
        assertEquals(5, rentalOfficeDTO.getEmployeesTotal());

    }

    @Test
    void rentalOfficeFromDTO() {
        RentalOfficeDTO rentalOfficeDTO = new RentalOfficeDTO();
        rentalOfficeDTO.setId(1L);
        rentalOfficeDTO.setName("Rental Office Name");
        rentalOfficeDTO.setAddress("Address");
        rentalOfficeDTO.setWebPage("rentaloffice.com");
        rentalOfficeDTO.setCarsTotal(10);
        rentalOfficeDTO.setEmployeesTotal(5);

        RentalOffice rentalOffice = rentalOfficeMapper.rentalOfficeFromDTO(rentalOfficeDTO);
        assertEquals(Long.valueOf(1), rentalOffice.getId());
        assertEquals("Rental Office Name", rentalOffice.getName());
        assertEquals("Address", rentalOffice.getAddress());
        assertEquals("rentaloffice.com", rentalOffice.getWebPage());
        assertEquals(10, rentalOffice.getCarsTotal());
        assertEquals(5, rentalOffice.getEmployeesTotal());

    }
}
