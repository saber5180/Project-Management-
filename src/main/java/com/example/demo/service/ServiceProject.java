package com.example.demo.service;

import com.example.demo.dto.DevDto;
import com.example.demo.dto.ProjectDto;
import com.example.demo.entity.Developper;
import com.example.demo.entity.Project;
import com.example.demo.entity.Task;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceProject implements IServiceProject{


    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    TaskRepository taskRepository;
    @Override
    public Project createProject(ProjectDto f) {

        Project p=new Project();
        p.setEndDate(f.getEndDate());
        p.setDescription(f.getDescription());
        p.setName(f.getName());
        p.setStartdate(f.getStartdate());


        return   projectRepository.save(p);
    }



    @Override
    public Project findProjectById(int id) {
        return null;
    }

    @Override
    public List<Project> findAllProjects() {

        List<Project> projects = projectRepository.findAll();

        return projects;
    }

    @Override
    public Project updateProject(ProjectDto f) {
        return null;
    }

    @Override
    public List<Task> getallTasks(int f) {
        return taskRepository.findAllByProjetsId(f);
    }

    @Override
    public void deleteProject(int id) {
        List<Task> l=taskRepository.findAllByProjetsId(id);
        l.forEach((task->{
            taskRepository.delete(task);


        }));
        taskRepository.saveAllAndFlush(l);
        projectRepository.deleteById(id);
    }
}
