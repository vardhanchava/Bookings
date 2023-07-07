package com.example.bookings.models.dto;

import lombok.Data;


@Data
public class UsersDto {
    private Long id;
    private String name;
    private Long age;
    private Character gender;
    private String email;
    private Long number;
//    private List<Bookings> userBookings;

}
