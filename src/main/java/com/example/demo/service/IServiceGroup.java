package com.example.demo.service;

import com.example.demo.dto.GroupDto;
import com.example.demo.entity.Group;

import java.util.List;

public interface IServiceGroup {
    public Group createGroup(GroupDto signUpDto) throws Exception;
    public Group getGroupById(int id);
    public List<Group> findAllGroups();
    public Group updateGroup(int id , Group f);
    public void deleteGroup(int id);
}
