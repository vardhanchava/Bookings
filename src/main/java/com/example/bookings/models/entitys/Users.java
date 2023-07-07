package com.example.bookings.models.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long age;
    private Character gender;
    private String email;
    private Long number;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Bookings> userBookings;
}