package com.example.demo.repository;

import com.example.demo.entity.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
     List<Task> findAllByProjetsId(int id) ;
}
