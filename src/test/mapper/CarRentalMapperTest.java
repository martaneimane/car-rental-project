package mapper;

import com.example.dto.CarRentalDTO;
import com.example.dto.mapper.CarRentalMapper;
import com.example.model.Booking;
import com.example.model.CarRental;
import com.example.model.Employee;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarRentalMapperTest {

    private CarRentalMapper carRentalMapper = new CarRentalMapper();

    private Employee employee = new Employee();
    private Booking booking = new Booking();

    @Test
    void carRentalToDTO() {

        CarRental carRental = new CarRental();
        carRental.setId(1L);
        carRental.setEmployee(employee);
        carRental.setRentalDate(LocalDate.of(2020, 1, 1));
        carRental.setBooking(booking);
        carRental.setComments("Test Comments");

        CarRentalDTO carRentalDTO = carRentalMapper.carRentalToDTO(carRental);
        assertEquals(Long.valueOf(1), carRentalDTO.getId());
        assertEquals(employee, carRentalDTO.getEmployee());
        assertEquals(LocalDate.of(2020, 1, 1), carRentalDTO.getRentalDate());
        assertEquals(booking, carRentalDTO.getBooking());
        assertEquals("Test Comments", carRentalDTO.getComments());

    }

    @Test
    void fromDto() {

        CarRentalDTO carRentalDTO = new CarRentalDTO();
        carRentalDTO.setId(1L);
        carRentalDTO.setEmployee(employee);
        carRentalDTO.setRentalDate(LocalDate.of(2020, 1, 1));
        carRentalDTO.setBooking(booking);
        carRentalDTO.setComments("Test Comments");

        CarRental carRental = carRentalMapper.fromDto(carRentalDTO);
        assertEquals(Long.valueOf(1), carRental.getId());
        assertEquals(employee, carRental.getEmployee());
        assertEquals(LocalDate.of(2020, 1, 1), carRental.getRentalDate());
        assertEquals(booking, carRental.getBooking());
        assertEquals("Test Comments", carRental.getComments());

    }
}
