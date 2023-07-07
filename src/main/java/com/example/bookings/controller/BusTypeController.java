package com.example.bookings.controller;

import com.example.bookings.converters.BusTypeConverter;
import com.example.bookings.models.dto.BusTypeDto;
import com.example.bookings.models.entitys.BusType;
import com.example.bookings.service.BusTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/busType")
public class BusTypeController {

    @Autowired
    private BusTypeService busTypeService;
    @Autowired
    private BusTypeConverter busTypeConverter;

    @PostMapping("/create")
    public ResponseEntity<BusTypeDto> createBus(@RequestBody BusTypeDto dto) {
        BusType busType = busTypeService.createBusType(busTypeConverter.dtoToBusType(dto));
        BusTypeDto busTypeDto = busTypeConverter.busTypeToDto(busType);
        return ResponseEntity.ok(busTypeDto);
    }

    @GetMapping("/get")
    public List<BusTypeDto> getAll() {
        return busTypeConverter.busTypeToDto(busTypeService.getAllBusTypes());
    }

}
