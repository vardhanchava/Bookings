package com.example.bookings.controller;

import com.example.bookings.converters.BusConverter;
import com.example.bookings.models.dto.BusDto;
import com.example.bookings.models.entitys.Bus;
import com.example.bookings.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {
    @Autowired
    private BusService busService;

    @Autowired
    private BusConverter busConverter;

    @GetMapping("/{Id}")
    public BusDto getBusById(@PathVariable("Id") Long id) {
        return busConverter.busToDto(busService.getBusById(id).getBody());
    }

    @PostMapping("/create")
    public ResponseEntity<BusDto> createBus(@RequestBody BusDto dto) {
        Bus bus = busService.createBus(busConverter.dtoToBus(dto));
        BusDto busDto = busConverter.busToDto(bus);
        return ResponseEntity.ok(busDto);
    }

    @PutMapping("/update/{Id}")
    public BusDto updateBusById(@PathVariable("Id") Long id, @RequestBody BusDto dto) {
        Bus bus = busService.updateBusById(id, dto);
        return busConverter.busToDto(bus);
    }

    @GetMapping("/get")
    public List<BusDto> getBusBookings() {
        List<BusDto> busDtos = busConverter.busToDto(busService.getAll());
        return busDtos;
    }
}

