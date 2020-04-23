package com.example.dto.mapper;

import com.example.dto.BookingDTO;
import com.example.model.Booking;
import org.springframework.stereotype.Service;

@Service
public class BookingMapper {
    public BookingDTO bookingToDto(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(booking.getId());
        bookingDTO.setBookingDate(booking.getBookingDate());
        bookingDTO.setCustomer(booking.getCustomer());
        bookingDTO.setCar(booking.getCar());
        bookingDTO.setDateFrom(booking.getDateFrom());
        bookingDTO.setDateTo(booking.getDateTo());
        bookingDTO.setBookingCost(booking.getBookingCost());
        return bookingDTO;
    }

    public Booking bookingFromDto(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setId(bookingDTO.getId());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setCustomer(bookingDTO.getCustomer());
        booking.setCar(bookingDTO.getCar());
        booking.setDateFrom(bookingDTO.getDateFrom());
        booking.setDateTo(bookingDTO.getDateTo());
        booking.setBookingCost(bookingDTO.getBookingCost());
        return booking;
    }
}
