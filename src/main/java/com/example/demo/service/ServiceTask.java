package com.example.demo.service;

import com.example.demo.dto.TacheDto;
import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTask implements IServiceTasks {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task createTask(TacheDto f) {
        Task t=new Task();
        t.setCommentaires(f.getCommentaires());
        t.setName(f.getName());
        t.setDescription(f.getDescription());
        t.setDurDate(f.getDurDate());
        t.setProjets(f.getProjets());






        return taskRepository.save(t);
    }

    @Override
    public Task findTaskById(int id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Task f) {
        return taskRepository.save(f);
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
