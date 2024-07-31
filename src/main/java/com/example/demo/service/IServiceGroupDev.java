package com.example.demo.service;

import com.example.demo.dto.GroupDevDto;
import com.example.demo.entity.Developper;
import com.example.demo.entity.GroupDev;

import java.util.List;

public interface IServiceGroupDev {
    public GroupDev createGroupDev(GroupDevDto f);
    public List<Developper> getTeamGroup(int id);
}
