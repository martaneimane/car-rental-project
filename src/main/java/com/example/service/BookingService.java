package com.example.service;

import com.example.dto.BookingDTO;
import com.example.dto.mapper.BookingMapper;
import com.example.model.Booking;
import com.example.model.Car;
import com.example.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Autowired
    private CarService carService;


    @Autowired
    public BookingService(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;

    }

    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(bookingMapper::bookingToDto)
                .collect(Collectors.toList());
    }


    public void createBooking(BookingDTO bookingDTO) {
        Booking booking = bookingMapper.bookingFromDto(bookingDTO);
        Car car = booking.getCar();
        carService.updateCarStatusToRented(car.getId());
        booking = bookingRepository.save(booking);

        booking.setBookingCost(this.calculateBookingCost(booking));
        bookingRepository.save(booking);

    }

    public void updateBooking(BookingDTO bookingDTO) {
        Booking booking = bookingMapper.bookingFromDto(bookingDTO);
        bookingRepository.save(booking);
    }

    public BookingDTO getBookingById(Long id) {
        Booking booking = bookingRepository.getOne(id);
        return bookingMapper.bookingToDto(booking);
    }

    public BigDecimal calculateBookingCost(Booking booking) {
        Car car = booking.getCar();
        BigDecimal carPrice = car.getPricePerDay();
        long bookingDays = ChronoUnit.DAYS.between(booking.getDateFrom(), booking.getDateTo());
        if (bookingDays == 0) {
            return carPrice;
        } else {
            return carPrice.multiply(BigDecimal.valueOf(bookingDays));
        }

    }
}
