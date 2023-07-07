package com.example.bookings.repository;

import com.example.bookings.models.entitys.BusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusTypeRepository extends JpaRepository<BusType, Long> {
   Optional <BusType> findById(Long id);

}
