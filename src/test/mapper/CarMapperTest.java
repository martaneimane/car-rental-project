package mapper;

import com.example.dto.CarDTO;
import com.example.dto.mapper.CarMapper;
import com.example.dto.mapper.CarRentalMapper;
import com.example.model.Car;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CarMapperTest {

    private CarMapper carMapper = new CarMapper();


    @Test
    void carsToDto() {

        Car car = new Car();
        car.setId(1L);
        car.setBrand("Test Brand");
        car.setModel("Test Model");
        car.setBodyType("Test Body Type");
        car.setYear(2020);
        car.setColor("Color");
        car.setMileage(8500);
        car.setStatus("Available");
        car.setPricePerDay(new BigDecimal("35.00"));

        CarDTO carDTO = carMapper.carsToDto(car);
        assertEquals(Long.valueOf(1), carDTO.getId());
        assertEquals("Test Brand", carDTO.getBrand());
        assertEquals("Test Model", carDTO.getModel());
        assertEquals("Test Body Type", carDTO.getBodyType());
        assertEquals(2020, carDTO.getYear());
        assertEquals("Color", carDTO.getColor());
        assertEquals(8500, carDTO.getMileage());
        assertEquals("Available", carDTO.getStatus());
        assertEquals(new BigDecimal("35.00"), carDTO.getPricePerDay());

    }

    @Test
    void fromDto() {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(1L);
        carDTO.setBrand("Test Brand");
        carDTO.setModel("Test Model");
        carDTO.setBodyType("Test Body Type");
        carDTO.setYear(2020);
        carDTO.setColor("Color");
        carDTO.setMileage(8500);
        carDTO.setStatus("Available");
        carDTO.setPricePerDay(new BigDecimal("35.00"));

        Car car = carMapper.fromDto(carDTO);
        assertEquals(Long.valueOf(1), car.getId());
        assertEquals("Test Brand", car.getBrand());
        assertEquals("Test Model", car.getModel());
        assertEquals("Test Body Type", car.getBodyType());
        assertEquals(2020, car.getYear());
        assertEquals("Color", car.getColor());
        assertEquals(8500, car.getMileage());
        assertEquals("Available", car.getStatus());
        assertEquals(new BigDecimal("35.00"), car.getPricePerDay());
    }
}
