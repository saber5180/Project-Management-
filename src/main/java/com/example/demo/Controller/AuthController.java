package com.example.demo.Controller;


import com.example.demo.config.JwtUtil;
import com.example.demo.dto.AuthenticationRequest;
import com.example.demo.dto.AuthenticationResponse;
import com.example.demo.dto.DevDto;
import com.example.demo.dto.SignUpDto;
import com.example.demo.entity.Developper;
import com.example.demo.mappers.UserMapper;
import com.example.demo.service.AuthServices;

import com.example.demo.service.ServiceDev;
import org.apache.el.stream.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000"  )
@RestController

public class AuthController {
    private final AuthServices authServices;
    private final ServiceDev serviceDev;
    public final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private String uploadDirectory= System.getProperty("user.dir")+"\\src\\main\\resources\\static\\image";
    public AuthController(AuthenticationManager authenticationManager, AuthServices authServices, ServiceDev serviceDev, UserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.authServices = authServices;

        this.authenticationManager = authenticationManager;
        this.serviceDev = serviceDev;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;

    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));

            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
            final String jwt = jwtUtil.generateToken(userDetails.getUsername(), serviceDev.findUserByUserName(userDetails.getUsername()));

            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect Username or Password");
        } catch (DisabledException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User Not Active");
        }
    }



    @PostMapping("/register")
    public ResponseEntity<?> signupUser(@RequestBody SignUpDto signUpDto ){






        Optional<Developper> user=serviceDev.findUserByUserName(signUpDto.getUserName());


        if (user != null) {

            return new ResponseEntity<>("User Existe deja ", HttpStatus.BAD_REQUEST);
        }
        try {
            DevDto createDevDto = authServices.createUser(signUpDto);




            return new ResponseEntity<>(createDevDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("erreur d'insertion", HttpStatus.BAD_REQUEST);
        }
    }
}


