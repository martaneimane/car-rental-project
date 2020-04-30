package controller;

import com.example.Application;
import com.example.controller.BookingController;
import com.example.dto.BookingDTO;
import com.example.service.BookingService;
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
@WebMvcTest(BookingController.class)
@ContextConfiguration(classes = Application.class)
class BookingControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookingService bookingService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    }

    @Test
    void getAllBookings() throws Exception {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(1L);
        bookingDTO.setBookingDate(LocalDate.of(2020,1,1));
    //    bookingDTO.setCar(1);
        bookingDTO.setDateFrom(LocalDate.of(2020,1,2));
        bookingDTO.setDateTo(LocalDate.of(2020,1,5));
        bookingDTO.setBookingCost(new BigDecimal("95.54"));

        List<BookingDTO> allBookings = Collections.singletonList(bookingDTO);

        given(bookingService.getAllBookings()).willReturn(allBookings);

        mvc.perform(get("/api/v1/rest/Booking/bookings")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(objectMapper.writeValueAsString(allBookings))));
    }

    @Test
    void createBooking() throws Exception {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(1L);
        bookingDTO.setBookingDate(LocalDate.of(2020,1,1));
     //   bookingDTO.setCar(1);
        bookingDTO.setDateFrom(LocalDate.of(2020,1,2));
        bookingDTO.setDateTo(LocalDate.of(2020,1,5));
        bookingDTO.setBookingCost(new BigDecimal("95.54"));

        mvc.perform(post("/api/v1/rest/Booking/booking")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bookingDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();


    }

    @Test
    void updateBooking() throws Exception {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(1L);
        bookingDTO.setBookingDate(LocalDate.of(2020,1,1));
     //   bookingDTO.setCar(1);
        bookingDTO.setDateFrom(LocalDate.of(2020,1,2));
        bookingDTO.setDateTo(LocalDate.of(2020,1,5));
        bookingDTO.setBookingCost(new BigDecimal("95.54"));


        mvc.perform(put("/api/v1/rest/Booking/booking")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bookingDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    void getBookingById() throws Exception {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(1L);
        bookingDTO.setBookingDate(LocalDate.of(2020,1,1));
     //   bookingDTO.setCar(1);
        bookingDTO.setDateFrom(LocalDate.of(2020,1,2));
        bookingDTO.setDateTo(LocalDate.of(2020,1,5));
        bookingDTO.setBookingCost(new BigDecimal("95.54"));

        given(bookingService.getBookingById(1L)).willReturn(bookingDTO);

        mvc.perform(get("/api/v1/rest/Booking/booking(1)")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(objectMapper.writeValueAsString(bookingDTO))));

    }
}
