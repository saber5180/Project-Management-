package com.example.demo.service;

import com.example.demo.dto.DevDto;
import com.example.demo.dto.GroupDto;

import com.example.demo.entity.Group;
import com.example.demo.entity.GroupDev;
import com.example.demo.entity.Task;
import com.example.demo.repository.GroupDevRepository;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceGroup implements IServiceGroup {
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    GroupDevRepository groupDevRepository;




    @Override
    public Group createGroup(GroupDto signUpDto) throws Exception {
        Group g =new Group();
        g.setName(signUpDto.getName());
        return groupRepository.save(g);
    }

    @Override
    public Group getGroupById(int id) {
        return null;
    }

    @Override
    public List<Group> findAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public Group updateGroup(int id, Group f) {
        return null;
    }

    @Override
    public void deleteGroup(int id) {

        List<GroupDev> l=groupDevRepository.findAllByGroupDevByGroupId(id);
        l.forEach((groupDev->{
            groupDevRepository.delete(groupDev);


        }));
        groupDevRepository.saveAllAndFlush(l);
        groupRepository.deleteById(id);

    }
}
