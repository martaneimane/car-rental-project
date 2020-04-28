package mapper;

import com.example.dto.CarRentalDTO;
import com.example.dto.mapper.CarRentalMapper;
import com.example.model.CarRental;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarRentalMapperTest {

    private CarRentalMapper carRentalMapper = new CarRentalMapper();

    @Test
    void carRentalToDTO() {

        CarRental carRental = new CarRental();
        carRental.setId(1L);
        carRental.setEmployee(1);
        carRental.setRentalDate(LocalDate.of(2020, 1, 1));
        carRental.setBooking(1);
        carRental.setComments("Test Comments");

        CarRentalDTO carRentalDTO = carRentalMapper.carRentalToDTO(carRental);
        assertEquals(Long.valueOf(1), carRentalDTO.getId());
        assertEquals(1, carRentalDTO.getEmployee());
        assertEquals(LocalDate.of(2020, 1, 1), carRentalDTO.getRentalDate());
        assertEquals(1, carRentalDTO.getBooking());
        assertEquals("Test Comments", carRentalDTO.getComments());

    }

    @Test
    void fromDto() {

        CarRentalDTO carRentalDTO = new CarRentalDTO();
        carRentalDTO.setId(1L);
        carRentalDTO.setEmployee(1);
        carRentalDTO.setRentalDate(LocalDate.of(2020, 1, 1));
        carRentalDTO.setBooking(1);
        carRentalDTO.setComments("Test Comments");

        CarRental carRental = carRentalMapper.fromDto(carRentalDTO);
        assertEquals(Long.valueOf(1), carRental.getId());
        assertEquals(1, carRental.getEmployee());
        assertEquals(LocalDate.of(2020, 1, 1), carRental.getRentalDate());
        assertEquals(1, carRental.getBooking());
        assertEquals("Test Comments", carRental.getComments());

    }
}
