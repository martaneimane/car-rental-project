package com.example.dto.mapper;
import com.example.dto.BookingDTO;
import com.example.model.Booking;
import org.springframework.stereotype.Service;

@Service
public class BookingMapper {
    public BookingDTO bookingToDto(Booking booking){
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(booking.getId());
        bookingDTO.setBooking_date(booking.getBooking_date());
        bookingDTO.setCustomer(booking.getCustomer());
        bookingDTO.setCar(booking.getCar());
        bookingDTO.setDate_from(booking.getDate_from());
        bookingDTO.setDate_to(booking.getDate_to());
        bookingDTO.setBooking_cost(booking.getBooking_cost());
        return bookingDTO;
    }
    public Booking fromDto(BookingDTO bookingDTO){
        Booking booking = new Booking();
        booking.setId(bookingDTO.getId());
        booking.setBooking_date(bookingDTO.getBooking_date());
        booking.setCustomer(bookingDTO.getCustomer());
        booking.setCar(bookingDTO.getCar());
        booking.setDate_from(bookingDTO.getDate_from());
        booking.setDate_to(bookingDTO.getDate_to());
        booking.setBooking_cost(bookingDTO.getBooking_cost());
        return booking;
    }
}
