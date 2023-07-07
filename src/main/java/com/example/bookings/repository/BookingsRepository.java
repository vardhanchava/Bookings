package com.example.bookings.repository;

import com.example.bookings.models.entitys.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings,Long> {

}
