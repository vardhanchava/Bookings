package com.example.bookings.models.dto;


import lombok.Data;

import java.util.Date;

@Data
public class BusDto {
    private Long id;
    private String name;
    private String number;
    private Date schedule;
    private BusTypeDto busType;
    private DriverDto driver;
}
