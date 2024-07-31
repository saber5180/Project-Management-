package com.example.demo.repository;

import com.example.demo.dto.DevDto;
import com.example.demo.entity.Developper;
import com.example.demo.entity.Group;
import com.example.demo.entity.GroupDev;
import com.example.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupDevRepository extends JpaRepository<GroupDev, Integer> {

    @Query("SELECT gd.developper FROM GroupDev gd WHERE gd.group.id = :id")
    List<Developper> findAllByGroupId(@Param("id") int id);

    @Query("SELECT gd FROM GroupDev gd WHERE gd.group.id = :id")
    List<GroupDev> findAllByGroupDevByGroupId(@Param("id") int id);




}
