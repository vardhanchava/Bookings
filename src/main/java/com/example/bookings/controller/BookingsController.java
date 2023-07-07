package com.example.bookings.controller;

import com.example.bookings.converters.BookingsConverter;
import com.example.bookings.models.dto.BookingsDto;
import com.example.bookings.models.entitys.Bookings;
import com.example.bookings.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingsController {

    @Autowired
    private BookingsConverter bookingsConverter;

    @Autowired
    private Service service;

    @GetMapping("/{Id}")
    public BookingsDto getBookingById(@PathVariable("Id") Long id) {
        return bookingsConverter.bookingsToDto(service.getBookingsById(id).getBody());
    }

    @PostMapping("/create")
    public ResponseEntity<BookingsDto> createBookings(@RequestBody BookingsDto request) {
        Bookings bookingsResponse = service.createBookings(bookingsConverter.dtoToBookings(request));
        BookingsDto response = bookingsConverter.bookingsToDto(bookingsResponse);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<String> deleteById(@PathVariable("Id") Long id) {
        return service.deleteBooking(id);
    }

    @PutMapping("/update/{Id}")
    public BookingsDto updateBookingsById(@PathVariable("Id") Long id, @RequestBody BookingsDto dto) {
        Bookings bookings = service.updateById(id, dto).getBody();
        return bookingsConverter.bookingsToDto(bookings);
    }

    @GetMapping("/get")
    public List<BookingsDto> getBookings() {
        List<BookingsDto> bookingsDtoList = bookingsConverter.bookingsToDto(service.getBookings());
        return bookingsDtoList;
    }
}