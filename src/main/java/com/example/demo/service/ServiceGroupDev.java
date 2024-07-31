package com.example.demo.service;

import com.example.demo.dto.GroupDevDto;
import com.example.demo.entity.Developper;
import com.example.demo.entity.GroupDev;
import com.example.demo.repository.GroupDevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceGroupDev implements IServiceGroupDev{


    @Autowired
    GroupDevRepository groupDevRepository;

    @Override
    public GroupDev createGroupDev(GroupDevDto f) {
        GroupDev groupDev = new GroupDev();
        groupDev.setGroup(f.getGroup());

        // Parcourir la liste des développeurs et les ajouter un par un
        for (Developper developper : f.getDeveloppers()) {
            GroupDev newGroupDev = new GroupDev();
            newGroupDev.setGroup(groupDev.getGroup()); // Référence le même groupe pour chaque développeur
            newGroupDev.setDevelopper(developper);
            groupDevRepository.save(newGroupDev);
        }

        return groupDev;
    }

    @Override
    public List<Developper> getTeamGroup(int id) {
        List<Developper> D=groupDevRepository.findAllByGroupId(id);


        return D;
    }

}
