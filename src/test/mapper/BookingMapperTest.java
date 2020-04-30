package mapper;

import com.example.dto.BookingDTO;
import com.example.dto.mapper.BookingMapper;
import com.example.model.Booking;
import com.example.model.Car;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingMapperTest {

    private BookingMapper bookingMapper = new BookingMapper();
    private Car car = new Car();

    @Test
    void bookingToDto() {


        Booking booking = new Booking();
        booking.setId(1L);
        booking.setBookingDate(LocalDate.of(2020, 1, 1));
        booking.setCar(car);
        booking.setDateFrom(LocalDate.of(2020, 1, 2));
        booking.setDateTo(LocalDate.of(2020, 1, 5));
        booking.setBookingCost(new BigDecimal("95.54"));

        BookingDTO bookingDTO = bookingMapper.bookingToDto(booking);
        assertEquals(Long.valueOf(1), bookingDTO.getId());
        assertEquals(LocalDate.of(2020, 1, 1), bookingDTO.getBookingDate());
        assertEquals(car, bookingDTO.getCar());
        assertEquals(LocalDate.of(2020, 1, 2), bookingDTO.getDateFrom());
        assertEquals(LocalDate.of(2020, 1, 5), bookingDTO.getDateTo());
        assertEquals(new BigDecimal("95.54"), bookingDTO.getBookingCost());


    }

    @Test
    void bookingFromDto() {

        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(1L);
        bookingDTO.setBookingDate(LocalDate.of(2020, 1, 1));
        bookingDTO.setCar(car);
        bookingDTO.setDateFrom(LocalDate.of(2020, 1, 2));
        bookingDTO.setDateTo(LocalDate.of(2020, 1, 5));
        bookingDTO.setBookingCost(new BigDecimal("95.54"));

        Booking booking = bookingMapper.bookingFromDto(bookingDTO);
        assertEquals(Long.valueOf(1), booking.getId());
        assertEquals(LocalDate.of(2020, 1, 1), booking.getBookingDate());
        assertEquals(car, booking.getCar());
        assertEquals(LocalDate.of(2020, 1, 2), booking.getDateFrom());
        assertEquals(LocalDate.of(2020, 1, 5), booking.getDateTo());
        assertEquals(new BigDecimal("95.54"), booking.getBookingCost());


    }
}
