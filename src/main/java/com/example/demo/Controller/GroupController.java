package com.example.demo.Controller;

import com.example.demo.dto.GroupDto;
import com.example.demo.dto.ProjectDto;
import com.example.demo.entity.Group;
import com.example.demo.entity.Project;
import com.example.demo.service.IServiceGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000"  )
    @RequestMapping("/group")
public class GroupController {

    @Autowired
    IServiceGroup iServiceGroup;

    @PostMapping("/addGroup")
    public ResponseEntity<?> AddGroup(@RequestBody GroupDto groupDto) throws Exception {
        try {
            Group createGroupDto = iServiceGroup.createGroup(groupDto);

            return new ResponseEntity<>(createGroupDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("erreur d'ajouter Group", HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Group>> listeGroup() {

        List<Group> projet=iServiceGroup.findAllGroups();
        return ResponseEntity.ok(projet) ;
    }
    @DeleteMapping("/deletegroup/{id}")
    public ResponseEntity<?> deletegroup(@PathVariable int id) {


        iServiceGroup.deleteGroup(id);
        return ResponseEntity.ok().build();
    }
}
