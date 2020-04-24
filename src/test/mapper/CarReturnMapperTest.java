package mapper;

import com.example.dto.CarReturnDTO;
import com.example.dto.mapper.CarReturnMapper;
import com.example.model.CarReturn;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class CarReturnMapperTest {

    private CarReturnMapper carReturnMapper = new CarReturnMapper();

    @Test
    void carReturnToDto() {
        CarReturn carReturn = new CarReturn();
        carReturn.setId(1L);
        carReturn.setEmployee(1);
        carReturn.setReturnDate(Date.valueOf("2020-01-01"));
        carReturn.setBooking(1);
        carReturn.setAdditionalPayments(new BigDecimal("10.00"));
        carReturn.setComments("Test Comments");

        CarReturnDTO carReturnDTO = carReturnMapper.carReturnToDto(carReturn);
        assertEquals(Long.valueOf(1), carReturnDTO.getId());
        assertEquals(1, carReturnDTO.getEmployee());
        assertEquals(Date.valueOf("2020-01-01"), carReturnDTO.getReturnDate());
        assertEquals(1, carReturnDTO.getBooking());
        assertEquals(new BigDecimal("10.00"), carReturnDTO.getAdditionalPayments());
        assertEquals("Test Comments", carReturnDTO.getComments());

    }

    @Test
    void fromDto() {

        CarReturnDTO carReturnDTO = new CarReturnDTO();
        carReturnDTO.setId(1L);
        carReturnDTO.setEmployee(1);
        carReturnDTO.setReturnDate(Date.valueOf("2020-01-01"));
        carReturnDTO.setBooking(1);
        carReturnDTO.setAdditionalPayments(new BigDecimal("10.00"));
        carReturnDTO.setComments("Test Comments");

        CarReturn carReturn = carReturnMapper.fromDto(carReturnDTO);
        assertEquals(Long.valueOf(1), carReturn.getId());
        assertEquals(1, carReturn.getEmployee());
        assertEquals(Date.valueOf("2020-01-01"), carReturn.getReturnDate());
        assertEquals(1, carReturn.getBooking());
        assertEquals(new BigDecimal("10.00"), carReturn.getAdditionalPayments());
        assertEquals("Test Comments", carReturn.getComments());

    }
}
