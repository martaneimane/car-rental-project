package mapper;

import com.example.dto.BookingDTO;
import com.example.dto.mapper.BookingMapper;
import com.example.model.Booking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.sql.Date;

class BookingMapperTest {

    private BookingMapper bookingMapper = new BookingMapper();

    @Test
    void bookingToDto() {
        Booking booking = new Booking();
        booking.setId(1L);
        booking.setBookingDate(Date.valueOf("2020-01-01"));
        booking.setCar(1);
        booking.setDateFrom(Date.valueOf("2020-01-02"));
        booking.setDateTo(Date.valueOf("2020-01-05"));
        booking.setBookingCost(new BigDecimal("95.54"));

        BookingDTO bookingDTO = bookingMapper.bookingToDto(booking);
        assertEquals(Long.valueOf(1), bookingDTO.getId());
        assertEquals(Date.valueOf("2020-01-01"), bookingDTO.getBookingDate());
        assertEquals(1, bookingDTO.getCar());
        assertEquals(Date.valueOf("2020-01-02"), bookingDTO.getDateFrom());
        assertEquals(Date.valueOf("2020-01-05"), bookingDTO.getDateTo());
        assertEquals(new BigDecimal("95.54"), bookingDTO.getBookingCost());


    }

    @Test
    void bookingFromDto() {

        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(1L);
        bookingDTO.setBookingDate(Date.valueOf("2020-01-01"));
        bookingDTO.setCar(1);
        bookingDTO.setDateFrom(Date.valueOf("2020-01-02"));
        bookingDTO.setDateTo(Date.valueOf("2020-01-05"));
        bookingDTO.setBookingCost(new BigDecimal("95.54"));

        Booking booking = bookingMapper.bookingFromDto(bookingDTO);
        assertEquals(Long.valueOf(1), booking.getId());
        assertEquals(Date.valueOf("2020-01-01"), booking.getBookingDate());
        assertEquals(1, booking.getCar());
        assertEquals(Date.valueOf("2020-01-02"), booking.getDateFrom());
        assertEquals(Date.valueOf("2020-01-05"), booking.getDateTo());
        assertEquals(new BigDecimal("95.54"), booking.getBookingCost());

    }
}
