package com.example.demo.Controller;

import com.example.demo.dto.DevDto;
import com.example.demo.dto.ProjectDto;
import com.example.demo.dto.SignUpDto;
import com.example.demo.entity.Developper;
import com.example.demo.entity.Project;
import com.example.demo.entity.Task;
import com.example.demo.service.IServiceProject;
import com.example.demo.service.IServiceTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000"  )
@RequestMapping("/Project")
public class ProjectController {


        @Autowired
        IServiceProject iServiceProject;
    @Autowired
    IServiceTasks iServiceTasks;
        @GetMapping("/all")
        public ResponseEntity<List<Project>> listeProject() {

            List<Project> projet=iServiceProject.findAllProjects();
            return ResponseEntity.ok(projet) ;
        }

    @GetMapping("/getAllTachwithid/{id}")
    public ResponseEntity<List<Task>> listeTach(@PathVariable int id) {

        List<Task> ls= iServiceProject.getallTasks(id);
        if(ls!=null)
        return ResponseEntity.ok(ls) ;
        else
            return ResponseEntity.ok(null) ;
    }


    @DeleteMapping("/deleteProject/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable int id) {


        iServiceProject.deleteProject(id);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/addProject")
    public ResponseEntity<?> signupUser(@RequestBody ProjectDto projectDto) {
        try {
            Project createDevDto = iServiceProject.createProject(projectDto);
            return new ResponseEntity<>(createDevDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("erreur d'ajouter", HttpStatus.BAD_REQUEST);
        }
    }




    }

