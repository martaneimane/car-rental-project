package controller;

import com.example.Application;
import com.example.controller.CarController;
import com.example.dto.CarDTO;
import com.example.service.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
@ContextConfiguration(classes = Application.class)
class CarControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarService carService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getAllCars() throws Exception {
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

        List<CarDTO> allCars = Collections.singletonList(carDTO);

        given(carService.getAllCars()).willReturn(allCars);


        mvc.perform(get("/api/v1/rest/Car/cars")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(objectMapper.writeValueAsString(allCars))));
    }

    @Test
    void getCarById() throws Exception {
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

        given(carService.getCarById(1L)).willReturn(carDTO);

        mvc.perform(get("/api/v1/rest/Car/cars(1)")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(objectMapper.writeValueAsString(carDTO))));
    }

    @Test
    void createCar() throws Exception {
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

        mvc.perform(post("/api/v1/rest/Car/car")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(carDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();


    }

    @Test
    void updateCar() throws Exception {

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

        mvc.perform(put("/api/v1/rest/Car/car")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(carDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();


    }
}
