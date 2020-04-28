package controller;

import com.example.Application;
import com.example.controller.CarRentalController;
import com.example.dto.CarRentalDTO;
import com.example.service.CarRentalService;
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

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CarRentalController.class)
@ContextConfiguration(classes = Application.class)
class CarRentalControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarRentalService carRentalService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    }

    @Test
    void getAllCarRentals() throws Exception {

        CarRentalDTO carRentalDTO = new CarRentalDTO();
        carRentalDTO.setId(1L);
        carRentalDTO.setEmployee(1);
        carRentalDTO.setRentalDate(LocalDate.of(2020, 1, 1));
        carRentalDTO.setBooking(1);
        carRentalDTO.setComments("Test Comments");

        List<CarRentalDTO> allCarRentals = Collections.singletonList(carRentalDTO);

        given(carRentalService.getAllCarRentals()).willReturn(allCarRentals);

        mvc.perform(get("/api/v1/rest/CarRental/carRentals")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(objectMapper.writeValueAsString(allCarRentals))));
    }

    @Test
    void createCarRental() throws Exception {
        CarRentalDTO carRentalDTO = new CarRentalDTO();
        carRentalDTO.setId(1L);
        carRentalDTO.setEmployee(1);
        carRentalDTO.setRentalDate(LocalDate.of(2020, 1, 1));
        carRentalDTO.setBooking(1);
        carRentalDTO.setComments("Test Comments");

        mvc.perform(post("/api/v1/rest/CarRental/carRental")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(carRentalDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

    }

    @Test
    void updateCarRental() throws Exception {

        CarRentalDTO carRentalDTO = new CarRentalDTO();
        carRentalDTO.setId(1L);
        carRentalDTO.setEmployee(1);
        carRentalDTO.setRentalDate(LocalDate.of(2020, 1, 1));
        carRentalDTO.setBooking(1);
        carRentalDTO.setComments("Test Comments");

        mvc.perform(put("/api/v1/rest/CarRental/carRental")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(carRentalDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    void getCarRentalById() throws Exception {

        CarRentalDTO carRentalDTO = new CarRentalDTO();
        carRentalDTO.setId(1L);
        carRentalDTO.setEmployee(1);
        carRentalDTO.setRentalDate(LocalDate.of(2020, 1, 1));
        carRentalDTO.setBooking(1);
        carRentalDTO.setComments("Test Comments");

        given(carRentalService.getCarRentalById(1L)).willReturn(carRentalDTO);

        mvc.perform(get("/api/v1/rest/CarRental/CarRental(1)")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(objectMapper.writeValueAsString(carRentalDTO))));
    }
}
