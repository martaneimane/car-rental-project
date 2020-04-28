package service;

import com.example.dto.BookingDTO;
import com.example.dto.mapper.BookingMapper;
import com.example.model.Booking;
import com.example.repository.BookingRepository;
import com.example.service.BookingService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookingServiceTest {

    private BookingRepository bookingRepository = mock(BookingRepository.class);
    BookingService bookingService = new BookingService(bookingRepository, new BookingMapper());

    @Test
    void getAllBookings() {
    }

    @Test
    void createBooking() {


    }

    @Test
    void updateBooking() {
    }

    @Test
    void getBookingById() {
        Booking booking = new Booking();
        booking.setId(1L);
        booking.setBookingDate(LocalDate.of(2020, 1, 1));
        booking.setCustomer(1);
        booking.setCar(1);
        booking.setDateFrom(LocalDate.of(2020, 1, 1));
        booking.setDateTo(LocalDate.of(2020, 1, 5));
        booking.setBookingCost(new BigDecimal("75.00"));

        when(bookingRepository.getOne(1L)).thenReturn(booking);
        BookingDTO bookingResult = bookingService.getBookingById(1L);

        assertEquals(Long.valueOf("1"), bookingResult.getId());
        assertEquals(LocalDate.of(2020, 1, 1), bookingResult.getBookingDate());
        assertEquals(1, bookingResult.getCustomer());
        assertEquals(1, bookingResult.getCar());
        assertEquals(LocalDate.of(2020, 1, 1), bookingResult.getDateFrom());
        assertEquals(LocalDate.of(2020, 1, 5), bookingResult.getDateTo());
        assertEquals(new BigDecimal("75.00"), bookingResult.getBookingCost());
    }
}
