package com.example.demo.dto;

import com.example.demo.entity.Developper;
import com.example.demo.entity.Project;
import com.example.demo.entity.Task;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data

public class ProjectDto {




    private  int id;
    private  String Name;
    private  String Description;

    private Date startdate;

    private  Date EndDate;

    List<Developper> developpers;

    List<Task> tasks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public List<Developper> getDeveloppers() {
        return developpers;
    }

    public void setDeveloppers(List<Developper> developpers) {
        this.developpers = developpers;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }


    public static ProjectDto toProjDto(Project project) {
        // Crée un nouvel objet UserDto
        ProjectDto projectDto = new ProjectDto();

        // Définit les attributs du UserDto en utilisant les valeurs de l'objet Developper passé en paramètre
        projectDto.setId(project.getId());
        projectDto.setDescription(project.getDescription());
        projectDto.setEndDate(project.getEndDate());
       // projectDto.setDeveloppers(project.getDeveloppers());
        projectDto.setStartdate(project.getStartdate());
        projectDto.setName(project.getName());

/*

        // Vérifie si l'utilisateur a un projet associé
        if (project.getTasks() != null) {
            // Si oui, définit l'identifiant du projet dans le UserDto
            projectDto.setTasks(project.getTasks());
        }
*/
        // Retourne l'objet UserDto
        return projectDto;
    }
}
