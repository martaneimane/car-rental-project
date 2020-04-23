package com.example.service;

import com.example.dto.BookingDTO;
import com.example.dto.mapper.BookingMapper;
import com.example.model.Booking;
import com.example.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Autowired
    public BookingService(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    public List<BookingDTO> getAllBookings(){
        return bookingRepository.findAll().stream()
                .map(bookingMapper::bookingToDto)
                .collect(Collectors.toList());
    }

    public void createBooking(BookingDTO bookingDTO){
        Booking booking = bookingMapper.bookingFromDto(bookingDTO);
        bookingRepository.save(booking);
    }

    public void updateBooking(BookingDTO bookingDTO) {
        Booking booking = bookingMapper.bookingFromDto(bookingDTO);
        bookingRepository.save(booking);
    }

    public BookingDTO getBookingById(Long id){
        Booking booking = bookingRepository.getOne(id);
        return bookingMapper.bookingToDto(booking);
    }



}
