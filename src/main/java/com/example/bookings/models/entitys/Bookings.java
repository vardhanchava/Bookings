package com.example.bookings.models.entitys;

import com.example.bookings.models.enums.Status;
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
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromCity;
    private String toCity;
    private Date bookingDate;
    private Date travelDate;
    private Long seatNo;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne(cascade = CascadeType.ALL)
    private Bus busDetails;
    @ManyToOne(cascade = CascadeType.ALL)
    private Users userDetails;
}
