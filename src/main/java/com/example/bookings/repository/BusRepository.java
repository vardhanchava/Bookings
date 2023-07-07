package com.example.bookings.repository;

import com.example.bookings.models.entitys.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<Bus,Long> {
    Optional<Bus> findById(Long id);

}
