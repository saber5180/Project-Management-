package com.example.demo.service.jwt;

import com.example.demo.entity.Developper;
import com.example.demo.repository.DevRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetaileServiceImp implements UserDetailsService {


    private  final DevRepository devRepository;


    public UserDetaileServiceImp(DevRepository devRepository) {
        this.devRepository = devRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Developper> dev= devRepository.findByUserName(username);
        if(dev.isEmpty())throw  new UsernameNotFoundException("User Not Found", null);
        return new org.springframework.security.core.userdetails.User(dev.get().getUserName(),dev.get().getPassword(),new ArrayList<>());

    }
}
