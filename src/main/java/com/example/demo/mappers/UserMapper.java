package com.example.demo.mappers;


import com.example.demo.dto.DevDto;
import com.example.demo.dto.SignUpDto;
import com.example.demo.entity.Developper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    DevDto toUserDto(Developper user);


    Developper signUpToUser(SignUpDto signUpDto);

}