package com.example.demo.repository;

import com.example.demo.entity.Project;

import com.example.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Integer> {

}
