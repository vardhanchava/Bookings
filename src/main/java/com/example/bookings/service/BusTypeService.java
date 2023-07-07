package com.example.bookings.service;

import com.example.bookings.models.entitys.BusType;
import com.example.bookings.repository.BusTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusTypeService {
    @Autowired
    private BusTypeRepository busTypeRepository;
    public BusType createBusType(BusType busType) {
        return busTypeRepository.save(busType);
    }

    public List<BusType> getAllBusTypes() {
        return busTypeRepository.findAll();
    }
}
