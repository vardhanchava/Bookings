package com.example.bookings.service;

import com.example.bookings.models.dto.BusDto;
import com.example.bookings.models.entitys.Bus;
import com.example.bookings.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {
    @Autowired
   private BusRepository busRepository;


    public Bus createBus(Bus bus) {
        return busRepository.save(bus);
    }

    public Bus updateBusById(Long id, BusDto dto) {
        Bus bus = busRepository.getById(id);
        return busRepository.save(bus);
    }

    public ResponseEntity<Bus> getBusById(Long id) {
        Optional<Bus> bus = busRepository.findById(id);
        if (bus.isPresent()) {
            Bus bus1 = bus.get();
            return ResponseEntity.ok(bus1);

        }
        return ResponseEntity.ok().build();
    }

    public List<Bus> getAll() {
        return busRepository.findAll();
    }
}
