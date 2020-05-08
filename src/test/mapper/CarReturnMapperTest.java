package mapper;

import com.example.dto.CarReturnDTO;
import com.example.dto.mapper.CarReturnMapper;
import com.example.model.Booking;
import com.example.model.CarReturn;
import com.example.model.Employee;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CarReturnMapperTest {

    private CarReturnMapper carReturnMapper = new CarReturnMapper();
    private Employee employee = new Employee();
    private Booking booking = new Booking();

    @Test
    void carReturnToDto() {
        CarReturn carReturn = new CarReturn();
        carReturn.setId(1L);
        carReturn.setEmployee(employee);
        carReturn.setReturnDate(LocalDate.of(2020, 1, 1));
        carReturn.setBooking(booking);
        carReturn.setAdditionalPayments(new BigDecimal("10.00"));
        carReturn.setComments("Test Comments");

        CarReturnDTO carReturnDTO = carReturnMapper.carReturnToDto(carReturn);
        assertEquals(Long.valueOf(1), carReturnDTO.getId());
        assertEquals(employee, carReturnDTO.getEmployee());
        assertEquals(LocalDate.of(2020, 1, 1), carReturnDTO.getReturnDate());
        assertEquals(booking, carReturnDTO.getBooking());
        assertEquals(new BigDecimal("10.00"), carReturnDTO.getAdditionalPayments());
        assertEquals("Test Comments", carReturnDTO.getComments());

    }

    @Test
    void fromDto() {

        CarReturnDTO carReturnDTO = new CarReturnDTO();
        carReturnDTO.setId(1L);
        carReturnDTO.setEmployee(employee);
        carReturnDTO.setReturnDate(LocalDate.of(2020, 1, 1));
        carReturnDTO.setBooking(booking);
        carReturnDTO.setAdditionalPayments(new BigDecimal("10.00"));
        carReturnDTO.setComments("Test Comments");

        CarReturn carReturn = carReturnMapper.fromDto(carReturnDTO);
        assertEquals(Long.valueOf(1), carReturn.getId());
        assertEquals(employee, carReturn.getEmployee());
        assertEquals(LocalDate.of(2020, 1, 1), carReturn.getReturnDate());
        assertEquals(booking, carReturn.getBooking());
        assertEquals(new BigDecimal("10.00"), carReturn.getAdditionalPayments());
        assertEquals("Test Comments", carReturn.getComments());

    }
}
