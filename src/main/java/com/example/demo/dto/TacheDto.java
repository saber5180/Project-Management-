package com.example.demo.dto;

import com.example.demo.entity.Commentaire;
import com.example.demo.entity.Project;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter

public class TacheDto {


    private int id;
    private String Name;
    private String Description;
    private Date DurDate;

    private Project projets;

    private List<Commentaire> commentaires;
}
