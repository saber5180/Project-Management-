package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TachDev {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;



    @ManyToOne
    @JoinColumn(name = "task_id", nullable = true)
    private   Task task;


    @ManyToOne
    @JoinColumn(name = "group_id", nullable = true)
    private Group group;


}
