package com.example.demo.dto;

import com.example.demo.Role.UserRole;
import com.example.demo.entity.Developper;

import lombok.Data;

import java.util.Optional;

@Data

public class DevDto {
    private  int id ;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    private UserRole role;
    private String image;

    private String token;



    public static DevDto toDevDto(Developper developper) {
        // Crée un nouvel objet UserDto
        DevDto devDto = new DevDto();

        // Définit les attributs du UserDto en utilisant les valeurs de l'objet Developper passé en paramètre
        devDto.setId(developper.getId());
        devDto.setFirstName(developper.getFirstName());
        devDto.setLastName(developper.getLastName());
        devDto.setRole(developper.getRole());
        devDto.setUserName(developper.getUserName());
        devDto.setEmail(developper.getEmail());
        devDto.setImage(developper.getImage());
        devDto.setToken(null);

        // Vérifie si l'utilisateur a un projet associé

        // Retourne l'objet UserDto
        return devDto;
    }




    public static Developper toDev(DevDto developperDto) {
        Developper developper = new Developper();
        developper.setId(developperDto.getId());
        developper.setFirstName(developperDto.getFirstName());
        developper.setLastName(developperDto.getLastName());
       // developper.setRole(developperDto.getRole());
        developper.setUserName(developperDto.getUserName());
        developper.setEmail(developperDto.getEmail());
        developper.setImage(developperDto.getImage());
        // Dans cet exemple, nous n'initialisons pas le projet associé à l'utilisateur.
        // Cela dépend de votre logique d'application si vous devez le faire ou non.
        return developper;
    }



    public int getId() {
        return id;
    }





    public void setId(int id)
        {
            this.id = id;
        }


    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setToken(String Token) {
        this.token = token;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getRole() {
//        return role;
//    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



}
