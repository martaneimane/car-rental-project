package controller;

import com.example.Application;
import com.example.controller.CarReturnController;
import com.example.dto.CarReturnDTO;
import com.example.model.Booking;
import com.example.model.Employee;
import com.example.service.CarReturnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
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
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarReturnController.class)
@ContextConfiguration(classes = Application.class)
class CarReturnControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarReturnService carReturnService;

    private ObjectMapper objectMapper = new ObjectMapper();
    private Employee employee = new Employee();
    private Booking booking = new Booking();

    @BeforeEach
    void setUp() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    }

    @Test
    void getAllCarsReturn() throws Exception {

        CarReturnDTO carReturnDTO = new CarReturnDTO();
        carReturnDTO.setId(1L);
        carReturnDTO.setEmployee(employee);
        carReturnDTO.setReturnDate(LocalDate.of(2020, 1, 5));
        carReturnDTO.setBooking(booking);
        carReturnDTO.setAdditionalPayments(new BigDecimal("00.00"));
        carReturnDTO.setComments("Test Comments");

        List<CarReturnDTO> allCarReturns = Collections.singletonList(carReturnDTO);

        given(carReturnService.getAllCarsReturn()).willReturn(allCarReturns);

        mvc.perform(get("/api/v1/rest/CarReturn/carsReturn")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(objectMapper.writeValueAsString(allCarReturns))));
    }

    @Test
    void createcarReturn() throws Exception {

        CarReturnDTO carReturnDTO = new CarReturnDTO();
        carReturnDTO.setId(1L);
        carReturnDTO.setEmployee(employee);
        carReturnDTO.setReturnDate(LocalDate.of(2020, 1, 5));
        carReturnDTO.setBooking(booking);
        carReturnDTO.setAdditionalPayments(new BigDecimal("00.00"));
        carReturnDTO.setComments("Test Comments");

        mvc.perform(post("/api/v1/rest/CarReturn/carReturn")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(carReturnDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

    }

    @Test
    void updateBooking() throws Exception {

        CarReturnDTO carReturnDTO = new CarReturnDTO();
        carReturnDTO.setId(1L);
        carReturnDTO.setEmployee(employee);
        carReturnDTO.setReturnDate(LocalDate.of(2020, 1, 5));
        carReturnDTO.setBooking(booking);
        carReturnDTO.setAdditionalPayments(new BigDecimal("00.00"));
        carReturnDTO.setComments("Test Comments");

        mvc.perform(put("/api/v1/rest/CarReturn/carReturn")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(carReturnDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    void getCarReturnById() throws Exception {
        CarReturnDTO carReturnDTO = new CarReturnDTO();
        carReturnDTO.setId(1L);
        carReturnDTO.setEmployee(employee);
        carReturnDTO.setReturnDate(LocalDate.of(2020, 1, 5));
        carReturnDTO.setBooking(booking);
        carReturnDTO.setAdditionalPayments(new BigDecimal("00.00"));
        carReturnDTO.setComments("Test Comments");


        given(carReturnService.getCarReturnById(1L)).willReturn(carReturnDTO);

        mvc.perform(get("/api/v1/rest/CarReturn/carReturn(1)")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(objectMapper.writeValueAsString(carReturnDTO))));
    }
}
