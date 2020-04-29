package service;

import com.example.dto.CarRentalDTO;
import com.example.dto.mapper.CarRentalMapper;
import com.example.model.CarRental;
import com.example.repository.CarRentalRepository;
import com.example.service.CarRentalService;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarRentalServiceTest {

    private CarRentalRepository carRentalRepository = mock(CarRentalRepository.class);
    CarRentalService carRentalService = new CarRentalService(carRentalRepository, new CarRentalMapper());

    @Test
    void getAllCarRentals() {

        List<CarRentalDTO> carRentalBeforeAdd = carRentalService.getAllCarRentals();

        CarRental carRental = new CarRental();
        carRental.setId(1L);

        when(carRentalRepository.findAll()).thenReturn(Collections.singletonList(carRental));
        List<CarRentalDTO> carRentalAfterAdd = carRentalService.getAllCarRentals();

        assertEquals(carRentalAfterAdd.size(), carRentalBeforeAdd.size() + 1);

    }

    @Test
    void createCarRental() {
        List<CarRentalDTO> carRentalBeforeAdd = carRentalService.getAllCarRentals();

        CarRental carRental = new CarRental();
        carRental.setId(1L);

        when(carRentalRepository.findAll()).thenReturn(Collections.singletonList(carRental));
        List<CarRentalDTO> carRentalAfterAdd = carRentalService.getAllCarRentals();

        assertEquals(carRentalAfterAdd.size(), carRentalBeforeAdd.size() + 1);

    }

    @Test
    void updateCarRental() {
        CarRental carRental = new CarRental();
        carRental.setId(1L);
        carRental.setEmployee(1);

        when(carRentalRepository.getOne(1L)).thenReturn(carRental);
        CarRentalDTO carRentalResult = carRentalService.getCarRentalById(1L);

        carRentalResult.setEmployee(2);
        carRentalService.updateCarRental(carRentalResult);

        assertEquals(2, carRentalResult.getEmployee());
    }

    @Test
    void getCarRentalById() {
        CarRental carRental = new CarRental();
        carRental.setId(1L);

        when(carRentalRepository.getOne(1L)).thenReturn(carRental);
        CarRentalDTO carRentalResult = carRentalService.getCarRentalById(1L);

        assertEquals(Long.valueOf("1"), carRentalResult.getId());


    }
}
