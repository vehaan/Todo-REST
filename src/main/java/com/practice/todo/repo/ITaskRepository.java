package com.practice.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.todo.entity.Task;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Integer> {

}
