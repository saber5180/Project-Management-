package com.example.demo.entity;

import com.example.demo.Role.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data

public class Developper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", nullable = false)
    @NotBlank(message = "First name is required")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotBlank(message = "Last name is required")
    private String lastName;

    @Column(name = "role", nullable = false)

    private UserRole role;

    @Column(name = "user_name", nullable = false, unique = true)
    @NotBlank(message = "Username is required")
    private String userName;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password is required")
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Email is not valid")
    private String email;

    @Column(name = "image")
    private String image;



    @JsonIgnore
    @OneToMany(mappedBy = "developper", cascade = CascadeType.ALL)
    private List<GroupDev> groupDevs;






}
