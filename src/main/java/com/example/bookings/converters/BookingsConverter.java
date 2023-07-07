package com.example.bookings.converters;

import com.example.bookings.models.dto.BookingsDto;
import com.example.bookings.models.entitys.Bookings;
import com.example.bookings.repository.BusRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookingsConverter {

    @Autowired
    private BusConverter busConverter;
    @Autowired
    private UsersToUsers userConverter;
    @Autowired
    private BusTypeConverter busTypeConverter;
    @Autowired
    private BusRepository busRepository;

    public BookingsDto bookingsToDto(Bookings bookings) {
        BookingsDto dto = new BookingsDto();
        BeanUtils.copyProperties(bookings, dto);
        dto.setBusDetails(busConverter.busToDto(bookings.getBusDetails()));
        dto.setUserDetails(userConverter.userToDto(bookings.getUserDetails()));
        return dto;
    }

    public List<BookingsDto> bookingsToDto(List<Bookings> bookings) {
        return bookings.stream().map(bookings1 -> bookingsToDto(bookings1)).collect(Collectors.toList());
    }

    public Bookings dtoToBookings(BookingsDto dto) {
        Bookings bookings = new Bookings();
        BeanUtils.copyProperties(dto, bookings);
        bookings.setBusDetails(busRepository.findById(dto.getBusDetails().getId()).get());
        bookings.setUserDetails(userConverter.dtoToUser(dto.getUserDetails()));
        return bookings;
    }
}
