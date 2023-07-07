package com.example.bookings.controller;

import com.example.bookings.converters.DriverToDriver;
import com.example.bookings.models.dto.DriverDto;
import com.example.bookings.models.entitys.Driver;
import com.example.bookings.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @Autowired
    private DriverToDriver driverConverter;

    @PostMapping("/create")
    public ResponseEntity<DriverDto> createDriver(@RequestBody DriverDto driverDto) {
        Driver createdDriver = driverService.createDriver(driverConverter.dtoToDriver(driverDto));
        DriverDto dto = driverConverter.driverToDto(createdDriver);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/get")
    public List<DriverDto> getAll() {
        List<DriverDto> driverDtos = driverConverter.driverToDto(driverService.getAllDrivers());
        return driverDtos;
    }
}
