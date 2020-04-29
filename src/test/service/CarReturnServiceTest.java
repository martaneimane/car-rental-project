package service;

import com.example.dto.CarReturnDTO;
import com.example.dto.mapper.CarReturnMapper;
import com.example.model.CarReturn;
import com.example.repository.CarReturnRepository;
import com.example.service.CarReturnService;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarReturnServiceTest {

    private CarReturnRepository carReturnRepository = mock(CarReturnRepository.class);
    CarReturnService carReturnService = new CarReturnService(carReturnRepository, new CarReturnMapper());

    @Test
    void getAllCarsReturn() {

        List<CarReturnDTO> carReturnBeforeAdd = carReturnService.getAllCarsReturn();

        CarReturn carReturn = new CarReturn();
        carReturn.setId(1L);

        when(carReturnRepository.findAll()).thenReturn(Collections.singletonList(carReturn));
        List<CarReturnDTO> carReturnAfterAdd = carReturnService.getAllCarsReturn();

        assertEquals(carReturnAfterAdd.size(), carReturnBeforeAdd.size() + 1);

    }

    @Test
    void createCarReturn() {
        List<CarReturnDTO> carReturnBeforeAdd = carReturnService.getAllCarsReturn();

        CarReturn carReturn = new CarReturn();
        carReturn.setId(1L);

        when(carReturnRepository.findAll()).thenReturn(Collections.singletonList(carReturn));
        List<CarReturnDTO> carReturnAfterAdd = carReturnService.getAllCarsReturn();

        assertEquals(carReturnAfterAdd.size(), carReturnBeforeAdd.size() + 1);
    }

    @Test
    void updateCarReturn() {

        CarReturn carReturn = new CarReturn();
        carReturn.setId(1L);
        carReturn.setEmployee(1);

        when(carReturnRepository.getOne(1L)).thenReturn(carReturn);
        CarReturnDTO carReturnResult = carReturnService.getCarReturnById(1L);

        carReturnResult.setEmployee(2);
        carReturnService.updateCarReturn(carReturnResult);

        assertEquals(2, carReturnResult.getEmployee());

    }

    @Test
    void getCarReturnById() {
        CarReturn carReturn = new CarReturn();
        carReturn.setId(1L);

        when(carReturnRepository.getOne(1L)).thenReturn(carReturn);
        CarReturnDTO carReturnResult = carReturnService.getCarReturnById(1L);

        assertEquals(Long.valueOf("1"), carReturnResult.getId());

    }
}
