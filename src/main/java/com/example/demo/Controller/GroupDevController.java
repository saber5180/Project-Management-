package com.example.demo.Controller;

import com.example.demo.dto.GroupDevDto;
import com.example.demo.dto.ProjectDto;
import com.example.demo.entity.*;
import com.example.demo.service.IServiceGroup;
import com.example.demo.service.IServiceGroupDev;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000"  )
@RequestMapping("/groupDev")
public class GroupDevController {

    @Autowired
    IServiceGroupDev iServiceGroupDev;


    @PostMapping("/addGroupDev")
    public ResponseEntity<?> creeGroupDev(@RequestBody GroupDevDto groupDev) {
        try {
            GroupDev CreateGroupDev = iServiceGroupDev.createGroupDev(groupDev);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/Team/{id}")
    public ResponseEntity<List<Developper>> listeDevByGroup(@PathVariable int id) {
        List<Developper> developers = iServiceGroupDev.getTeamGroup(id);

        if (developers != null && !developers.isEmpty()) {
            return ResponseEntity.ok(developers);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


}
