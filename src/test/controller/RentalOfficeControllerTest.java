package controller;

import com.example.Application;
import com.example.controller.RentalOfficeController;
import com.example.dto.RentalOfficeDTO;
import com.example.service.RentalOfficeService;
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

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RentalOfficeController.class)
@ContextConfiguration(classes = Application.class)
class RentalOfficeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RentalOfficeService rentalOfficeService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    }

    @Test
    void getAllRentalOffices() throws Exception {
        RentalOfficeDTO rentalOfficeDTO = new RentalOfficeDTO();
        rentalOfficeDTO.setId(1L);
        rentalOfficeDTO.setName("Rental Office Name");
        rentalOfficeDTO.setAddress("Address");
        rentalOfficeDTO.setWebPage("www.example.com");
        rentalOfficeDTO.setCarsTotal(10);
        rentalOfficeDTO.setEmployeesTotal(5);

        List<RentalOfficeDTO> allOffices = Collections.singletonList(rentalOfficeDTO);

        given(rentalOfficeService.getAllRentalOffices()).willReturn(allOffices);

        mvc.perform(get("/api/v1/rest/RentalOffice/rental-offices")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(objectMapper.writeValueAsString(allOffices))));
    }

    @Test
    void getRentalOfficeById() throws Exception {

        RentalOfficeDTO rentalOfficeDTO = new RentalOfficeDTO();
        rentalOfficeDTO.setId(1L);
        rentalOfficeDTO.setName("Rental Office Name");
        rentalOfficeDTO.setAddress("Address");
        rentalOfficeDTO.setWebPage("www.example.com");
        rentalOfficeDTO.setCarsTotal(10);
        rentalOfficeDTO.setEmployeesTotal(5);

        given(rentalOfficeService.getRentalOfficeById(1L)).willReturn(rentalOfficeDTO);

        mvc.perform(get("/api/v1/rest/RentalOffice/rental-office(1)")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(objectMapper.writeValueAsString(rentalOfficeDTO))));

    }

    @Test
    void createRentalOffice() throws Exception {
        RentalOfficeDTO rentalOfficeDTO = new RentalOfficeDTO();
        rentalOfficeDTO.setId(1L);
        rentalOfficeDTO.setName("Rental Office Name");
        rentalOfficeDTO.setAddress("Address");
        rentalOfficeDTO.setWebPage("www.example.com");
        rentalOfficeDTO.setCarsTotal(10);
        rentalOfficeDTO.setEmployeesTotal(5);

        mvc.perform(post("/api/v1/rest/RentalOffice/rental-office")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(rentalOfficeDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

    }

    @Test
    void updateRentalOffice() throws Exception {
        RentalOfficeDTO rentalOfficeDTO = new RentalOfficeDTO();
        rentalOfficeDTO.setId(1L);
        rentalOfficeDTO.setName("Rental Office Name");
        rentalOfficeDTO.setAddress("Address");
        rentalOfficeDTO.setWebPage("www.example.com");
        rentalOfficeDTO.setCarsTotal(10);
        rentalOfficeDTO.setEmployeesTotal(5);

        mvc.perform(put("/api/v1/rest/RentalOffice/rental-office")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(rentalOfficeDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }
}
