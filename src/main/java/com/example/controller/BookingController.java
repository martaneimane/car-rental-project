package com.example.controller;

import com.example.dto.BookingDTO;
import com.example.dto.CarDTO;
import com.example.dto.mapper.CarMapper;
import com.example.service.BookingService;
import com.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest/Booking")
public class BookingController {

    private final BookingService bookingService;
    private final CarService carService;
    private final CarMapper carMapper;

    @Autowired
    public BookingController(BookingService bookingService, CarService carService, CarMapper carMapper) {
        this.bookingService = bookingService;
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @GetMapping("/bookings")
    public List<BookingDTO> getAllBookings() {
        return bookingService.getAllBookings();
    }


    @PostMapping("/booking")
    public void createBooking(@RequestBody BookingDTO bookingDTO) {
        CarDTO carDTO = carMapper.carsToDto(bookingDTO.getCar());
        carService.updateCarStatusToRented(carDTO.getId());
        bookingService.createBooking(bookingDTO);
    }

    @PutMapping("/booking")
    public void updateBooking(@RequestBody BookingDTO bookingDTO) {
        bookingService.updateBooking(bookingDTO);
    }

    @GetMapping("/booking({id})")
    public BookingDTO getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }
}
