package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String Name;
    private  String Description;
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Temporal(TemporalType.DATE)
    private Date EndDate;

    @JsonIgnore
    @OneToMany(mappedBy = "projets", cascade = CascadeType.ALL)
    List<Task> tasks;
}
