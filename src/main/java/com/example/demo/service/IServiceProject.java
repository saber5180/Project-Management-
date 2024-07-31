package com.example.demo.service;

import com.example.demo.dto.ProjectDto;
import com.example.demo.entity.Project;
import com.example.demo.entity.Task;

import java.util.List;

public interface IServiceProject {
    public Project createProject(ProjectDto f);
    public Project findProjectById(int id);
    public List<Project> findAllProjects();
    public Project updateProject(ProjectDto f);
    public List<Task> getallTasks(int f);
    public void deleteProject(int id);
}
