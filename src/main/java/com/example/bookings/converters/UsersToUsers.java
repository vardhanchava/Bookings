package com.example.bookings.converters;

import com.example.bookings.models.dto.UsersDto;
import com.example.bookings.models.entitys.Users;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UsersToUsers {
public Users dtoToUser (UsersDto dto){
    Users users = new Users();
    BeanUtils.copyProperties(dto,users);
    return users;
}
public UsersDto userToDto (Users users){
    UsersDto usersDto = new UsersDto();
    BeanUtils.copyProperties(users,usersDto);
    return usersDto;
}
}
