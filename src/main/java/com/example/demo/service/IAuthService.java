package com.example.demo.service;

import com.example.demo.dto.DevDto;
import com.example.demo.dto.SignUpDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface IAuthService {
    DevDto createUser(SignUpDto signUpDto);
}
