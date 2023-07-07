package com.example.bookings.models.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name ;
    private String number;
    private Date schedule;
    @ManyToOne(cascade = CascadeType.ALL)
    private BusType  busType;
    @ManyToOne(cascade = CascadeType.ALL)
    private Driver driver;
}
