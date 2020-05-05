package service;

import com.example.dto.CarDTO;
import com.example.dto.mapper.BookingMapper;
import com.example.dto.mapper.CarMapper;
import com.example.model.Car;
import com.example.repository.CarRepository;
import com.example.service.CarService;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarServiceTest {

    private final CarRepository carRepository = mock(CarRepository.class);
    CarService carService = new CarService(carRepository, new CarMapper(), new BookingMapper());


    @Test
    void getAllCars() {
        List<CarDTO> carBeforeAdd = carService.getAllCars();

        Car car = new Car();
        car.setId(1L);

        when(carRepository.findAll()).thenReturn(Collections.singletonList(car));
        List<CarDTO> carAfterAdd = carService.getAllCars();

        assertEquals(carAfterAdd.size(), carBeforeAdd.size() + 1);

    }

    @Test
    void createCar() {
        List<CarDTO> carBeforeAdd = carService.getAllCars();

        Car car = new Car();
        car.setId(1L);

        when(carRepository.findAll()).thenReturn(Collections.singletonList(car));
        List<CarDTO> carAfterAdd = carService.getAllCars();

        assertEquals(carAfterAdd.size(), carBeforeAdd.size() + 1);
    }

    @Test
    void updateCar() {

        Car car = new Car();
        car.setId(1L);
        car.setStatus("Available");

        when(carRepository.getOne(1L)).thenReturn(car);
        CarDTO carResult = carService.getCarById(1L);

        carResult.setStatus("Unavailable");
        carService.updateCar(carResult);

        assertEquals("Unavailable", carResult.getStatus());

    }

    @Test
    void getCarById() {

        Car car = new Car();
        car.setId(1L);

        when(carRepository.getOne(1L)).thenReturn(car);
        CarDTO carResult = carService.getCarById(1L);

        assertEquals(Long.valueOf("1"), carResult.getId());

    }
}
