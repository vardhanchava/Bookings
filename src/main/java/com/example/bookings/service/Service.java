package com.example.bookings.service;

import com.example.bookings.models.dto.BookingsDto;
import com.example.bookings.models.entitys.Bookings;
import com.example.bookings.models.entitys.BusType;
import com.example.bookings.models.enums.Status;
import com.example.bookings.models.entitys.Users;
import com.example.bookings.repository.BookingsRepository;
import com.example.bookings.repository.BusTypeRepository;
import com.example.bookings.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

@org.springframework.stereotype.Service
public class Service {


    @Autowired
    private BookingsRepository bookingsRepository;
    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private BusTypeRepository busTypeRepository;


    public Bookings createBookings(Bookings bookings) {
        bookings.setBookingDate(new Date());
        BusType busType = busTypeRepository.findById(bookings.getBusDetails().getBusType().getId()).orElse(null);
        if (bookings.getSeatNo() <= busType.getSeats()) {
            bookings.setStatus(Status.CONFIRMED);
        } else {
            bookings.setStatus(Status.CANCELLED);
        }
        return bookingsRepository.save(bookings);
    }


    public ResponseEntity<String> deleteBooking(Long id) {
        bookingsRepository.deleteById(id);
        return new ResponseEntity<>("deleted Successfully", HttpStatus.OK);
    }


    public ResponseEntity<Bookings> updateById(Long id, BookingsDto dto) {
        Bookings existingBookings = bookingsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Bookings not found"));
        bookingsRepository.save(existingBookings);
        return ResponseEntity.ok(existingBookings);
    }


    public ResponseEntity<Bookings> getBookingsById(Long id) {
        Optional<Bookings> optionalBooking = bookingsRepository.findById(id);
        if (optionalBooking.isPresent()) {
            Bookings booking = optionalBooking.get();
            return ResponseEntity.ok(booking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Users> getUsersById(Long id) {
        Optional<Users> optionalUsers = userRepository.findById(id);
        if (optionalUsers.isPresent()) {
            Users users = optionalUsers.get();
            return ResponseEntity.ok(users);
        }
        return ResponseEntity.notFound().build();
    }


    public List<Bookings> getBookings() {
        return bookingsRepository.findAll();
    }


}