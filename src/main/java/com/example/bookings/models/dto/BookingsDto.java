package com.example.bookings.models.dto;

import com.example.bookings.models.enums.Status;
import lombok.Data;

import java.util.Date;

@Data
public class BookingsDto {
    private Long id;
    private String fromCity;
    private String toCity;
    private Date bookingDate;
    private Date travelDate;
    private Long seatNo;
    private Status status;
    private BusDto busDetails;
    private UsersDto userDetails;
}
