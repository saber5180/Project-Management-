package com.example.demo.Controller;


import com.example.demo.dto.TacheDto;
import com.example.demo.entity.Task;
import com.example.demo.service.IServiceProject;
import com.example.demo.service.IServiceTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000"  )
    @RequestMapping("/tasks")
public class TacheContoller {

    @Autowired
    IServiceTasks iServiceTasks;
    @Autowired
    IServiceProject iServiceProject;
    @GetMapping("/all/{id}")
    public ResponseEntity<List<Task>> listeTache(@PathVariable int id) {

        List<Task> task=iServiceProject.getallTasks(id);
        return ResponseEntity.ok(task) ;
    }



    @DeleteMapping("/deletetach/{id}")
    public ResponseEntity<?> deletetach(@PathVariable int id) {
        // Your delete logic here
        iServiceTasks.deleteTask(id);
        return ResponseEntity.ok().build();
    }



    @PostMapping("/addTache")
    public ResponseEntity<?> crerTAche(@RequestBody TacheDto tachDto) {
        try {
            Task task = iServiceTasks.createTask(tachDto);
            return new ResponseEntity<>(task, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("erreur d'ajouter", HttpStatus.BAD_REQUEST);
        }
    }

}
