package com.example.demo.dto;

import com.example.demo.entity.Developper;
import com.example.demo.entity.Group;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class GroupDevDto {
    private List<Developper> developpers = new ArrayList<>(); // Initialisation de la liste

    private Group group;

    public List<Developper> getDeveloppers() {
        return developpers;
    }

    public void setDeveloppers(List<Developper> developpers) {
        this.developpers = developpers;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
