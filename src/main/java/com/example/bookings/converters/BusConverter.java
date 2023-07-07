package com.example.bookings.converters;

import com.example.bookings.models.dto.BusDto;
import com.example.bookings.models.entitys.Bus;
import com.example.bookings.repository.BusTypeRepository;
import com.example.bookings.repository.DriverRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BusConverter {

    @Autowired
    private BusTypeConverter busTypeConverter;

    @Autowired
    private DriverToDriver driverConverter;

    @Autowired
    private BusTypeRepository busTypeRepository;

    @Autowired
    private DriverRepository driverRepository;

    public BusDto busToDto(Bus bus) {
        BusDto busDto = new BusDto();
        BeanUtils.copyProperties(bus, busDto);
        busDto.setBusType(busTypeConverter.busTypeToDto(bus.getBusType()));
        busDto.setDriver(driverConverter.driverToDto(bus.getDriver()));
        return busDto;
    }

    public List<BusDto> busToDto(List<Bus> buses) {
        return buses.stream().map(bus -> busToDto(bus)).collect(Collectors.toList());
    }

    public Bus dtoToBus(BusDto dto) {
        Bus bus = new Bus();
        BeanUtils.copyProperties(dto, bus);
        bus.setBusType(busTypeRepository.findById(dto.getBusType().getId()).get());
        bus.setDriver(driverRepository.findById(dto.getDriver().getId()).get());
        return bus;
    }
}
