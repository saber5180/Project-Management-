package com.example.demo.Controller;

import com.example.demo.dto.DevDto;
import com.example.demo.dto.SignUpDto;
import com.example.demo.entity.Developper;
import com.example.demo.service.IServiceDev;

import com.example.demo.service.ServiceDev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Dev")
public class DevController {

    private final ServiceDev serviceDev;

    public DevController(ServiceDev serviceDev) {
        this.serviceDev = serviceDev;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DevDto>> listeUsers() {

        List<DevDto>users = serviceDev.findAllUsers();
        return ResponseEntity.ok(users) ;
    }


    @PostMapping("/addDev")
    public ResponseEntity<?> addUser(@RequestBody SignUpDto signUpDto) {

        Optional<Developper> user=serviceDev.findUserByUserName(signUpDto.getUserName());


        if (user != null) {

            return new ResponseEntity<>("User Existe deja ", HttpStatus.BAD_REQUEST);
        }else {
            if (signUpDto.getUserName().isEmpty()||signUpDto.getPassword().isEmpty())
                return new ResponseEntity<>("User is empty ", HttpStatus.BAD_REQUEST);
        }

        try {
            DevDto createDevDto = serviceDev.createUser(signUpDto);

           return new ResponseEntity<>(createDevDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Developper> getUserById(@PathVariable("id") int id) {

        Developper em= serviceDev.getUserById(id);
        return ResponseEntity.ok(em);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteUserById(@PathVariable("id") int id) {

        serviceDev.deleteUser(id);
        return ResponseEntity.ok("Developper deleted successfuly");
    }



}