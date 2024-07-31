package com.example.demo.service;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Role.UserRole;
import com.example.demo.dto.DevDto;
import com.example.demo.dto.SignUpDto;
import com.example.demo.entity.*;


import com.example.demo.mappers.UserMapper;
import com.example.demo.repository.DevRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ServiceDev implements IServiceDev {

    @Autowired
    DevRepository DevRepository;



    @Override
    public Developper getUserById(int id) {
        return DevRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Developper does not exist with id: " + id));
    }

    @Override
    public List<DevDto> findAllUsers() {
        List<Developper> developpers = DevRepository.findAll();
        List<DevDto> devDtos = new ArrayList<>();
        for (Developper developper : developpers) {

            devDtos.add(DevDto.toDevDto(developper));
        }

        return devDtos;
    }




    @Override
    public Developper updateUser(int id, Developper developper) {
        Developper existingDevelopper = DevRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Developper does not exist with id: " + id));
        existingDevelopper.setUserName(developper.getUserName());
        existingDevelopper.setEmail(developper.getEmail());
        existingDevelopper.setFirstName(developper.getFirstName());
        existingDevelopper.setPassword(developper.getPassword());
        // Il semble y avoir une erreur ici, vous définissez à nouveau le nom d'utilisateur (existingDevelopper.setUserName(developper.getUserName())), cela devrait probablement être le nom de famille, donc je vais le corriger.
        existingDevelopper.setLastName(developper.getLastName());

        return DevRepository.save(existingDevelopper);
    }

    @Override
    public void deleteUser(int id) {
        DevRepository.deleteById(id);
    }
//////////***************
    @Override
    public Optional<Developper> findUserByUserName(String userName) {
        Optional<Developper> optionalUser = DevRepository.findByUserName(userName);
        if(optionalUser.isEmpty())
            return null;

        else
            return optionalUser;
    }


    @Override
    public DevDto createUser(SignUpDto signUpDto) {
        Developper developper=new Developper();
        developper.setUserName(signUpDto.getUserName());
        developper.setFirstName(signUpDto.getFirstName());
        developper.setEmail(signUpDto.getEmail());
        developper.setLastName(signUpDto.getLastName());

        developper.setRole(UserRole.DEVELOPPER);
        developper.setPassword(new BCryptPasswordEncoder().encode(signUpDto.getPassword()));
        Developper CreateDev= DevRepository.save(developper);


        DevDto developperDto=new DevDto();
        developperDto.setUserName(CreateDev.getUserName());
        developperDto.setFirstName(CreateDev.getFirstName());
        developperDto.setEmail(CreateDev.getEmail());
        developperDto.setLastName(CreateDev.getLastName());

        developperDto.setRole(CreateDev.getRole());
        developperDto.setId(CreateDev.getId());

        return developperDto;
    }






}
