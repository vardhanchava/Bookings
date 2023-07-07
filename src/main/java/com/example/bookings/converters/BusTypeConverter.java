package com.example.bookings.converters;

import com.example.bookings.models.dto.BusTypeDto;
import com.example.bookings.models.entitys.BusType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BusTypeConverter {

    public BusTypeDto busTypeToDto(BusType busType) {
        BusTypeDto busTypeDto = new BusTypeDto();
        BeanUtils.copyProperties(busType, busTypeDto);
        return busTypeDto;
    }

    public List<BusTypeDto> busTypeToDto(List<BusType> busType) {
        return busType.stream().map(busType1 -> busTypeToDto(busType1)).collect(Collectors.toList());
    }

    public BusType dtoToBusType(BusTypeDto busTypeDto) {
        BusType busType = new BusType();
        BeanUtils.copyProperties(busTypeDto, busType);
        return busType;
    }

}
