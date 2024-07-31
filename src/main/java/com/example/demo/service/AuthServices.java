package com.example.demo.service;

import com.example.demo.Role.UserRole;
import com.example.demo.dto.DevDto;
import com.example.demo.dto.SignUpDto;
import com.example.demo.entity.Developper;
import com.example.demo.repository.DevRepository;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthServices implements IAuthService{
    private final DevRepository devRepository;


    public AuthServices(DevRepository devRepository) {
        this.devRepository = devRepository;

    }


    @Override
    public DevDto createUser(SignUpDto signUpDto) {
        Developper developper=new Developper();
        developper.setUserName(signUpDto.getUserName());
        developper.setFirstName(signUpDto.getFirstName());
        developper.setEmail(signUpDto.getEmail());
        developper.setLastName(signUpDto.getLastName());
        developper.setImage(signUpDto.getImage());
        developper.setRole(UserRole.DEVELOPPER);
        developper.setPassword(new BCryptPasswordEncoder().encode(signUpDto.getPassword()));
        Developper CreateDev= devRepository.save(developper);


        DevDto developperDto=new DevDto();
        developperDto.setUserName(CreateDev.getUserName());
        developperDto.setFirstName(CreateDev.getFirstName());
        developperDto.setEmail(CreateDev.getEmail());
        developperDto.setLastName(CreateDev.getLastName());
        developperDto.setImage(CreateDev.getImage());
        developperDto.setRole(CreateDev.getRole());
        developperDto.setId(CreateDev.getId());

        return developperDto;
    }
}
