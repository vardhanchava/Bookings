package com.example.bookings.converters;

import com.example.bookings.models.dto.DriverDto;
import com.example.bookings.models.entitys.Driver;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DriverToDriver {
    public DriverDto driverToDto(Driver driver) {
        DriverDto dto = new DriverDto();
        BeanUtils.copyProperties(driver, dto);
        return dto;
    }
    public List<DriverDto> driverToDto(List<Driver> drivers) {
        return drivers.stream().map(driver -> driverToDto(driver)).collect(Collectors.toList());
    }

    public Driver dtoToDriver(DriverDto dto) {
        Driver driver = new Driver();
        BeanUtils.copyProperties(dto, driver);
        return driver;
    }
}
