package service;

import com.example.dto.BookingDTO;
import com.example.dto.mapper.BookingMapper;

import com.example.model.Booking;
import com.example.repository.BookingRepository;
import com.example.service.BookingService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookingServiceTest {

    private BookingRepository bookingRepository = mock(BookingRepository.class);
    BookingService bookingService = new BookingService(bookingRepository, new BookingMapper());

    @Test
    void getAllBookings() {
        List<BookingDTO> bookingBeforeAdd = bookingService.getAllBookings();

        Booking booking = new Booking();
        booking.setId(1L);

        when(bookingRepository.findAll()).thenReturn(Collections.singletonList(booking));
        List<BookingDTO> bookingAfterAdd = bookingService.getAllBookings();

        assertEquals(bookingAfterAdd.size(), bookingBeforeAdd.size() +1);
    }

    @Test
    void createBooking() {
        List<BookingDTO> bookingBeforeAdd = bookingService.getAllBookings();

        Booking booking = new Booking();
        booking.setId(1L);

        when(bookingRepository.findAll()).thenReturn(Collections.singletonList(booking));
        List<BookingDTO> bookingAfterAdd = bookingService.getAllBookings();

        assertEquals(bookingAfterAdd.size(), bookingBeforeAdd.size() +1);
    }

    @Test
    void updateBooking() {
        Booking booking = new Booking();
        booking.setId(1L);
        booking.setBookingCost(new BigDecimal(100));

        when(bookingRepository.getOne(1L)).thenReturn(booking);
        BookingDTO bookingResult = bookingService.getBookingById(1L);

        bookingResult.setBookingCost(new BigDecimal(200));
        bookingService.updateBooking(bookingResult);

        assertEquals(new BigDecimal(200),bookingResult.getBookingCost());
    }

    @Test
    void getBookingById() {
        Booking booking = new Booking();
        booking.setId(1L);
        booking.setBookingDate(LocalDate.of(2020, 1, 1));

        when(bookingRepository.getOne(1L)).thenReturn(booking);
        BookingDTO bookingResult = bookingService.getBookingById(1L);

        assertEquals(Long.valueOf("1"), bookingResult.getId());
        assertEquals(LocalDate.of(2020, 1, 1), bookingResult.getBookingDate());
    }
}
