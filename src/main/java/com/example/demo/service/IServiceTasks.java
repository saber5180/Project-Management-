package com.example.demo.service;

import com.example.demo.dto.TacheDto;
import com.example.demo.entity.Task;


import java.util.List;

public interface IServiceTasks {
    public Task createTask(TacheDto f);
    public Task findTaskById(int id);
    public List<Task> findAllTasks();
    public Task updateTask(Task f);
    public void deleteTask(int id);
}
