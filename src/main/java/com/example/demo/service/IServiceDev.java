package com.example.demo.service;

import com.example.demo.dto.DevDto;
import com.example.demo.dto.SignUpDto;
import com.example.demo.entity.Developper;


import java.util.List;
import java.util.Optional;

public interface IServiceDev {
    public DevDto createUser(SignUpDto signUpDto) throws Exception;
    public Developper getUserById(int id);
    public List<DevDto> findAllUsers();
    public Developper updateUser(int id , Developper f);
    public void deleteUser(int id);



    Optional<Developper> findUserByUserName(String userName);
}
