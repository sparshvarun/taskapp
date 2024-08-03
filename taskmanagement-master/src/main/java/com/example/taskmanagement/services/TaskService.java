package com.example.taskmanagement.services;

import com.example.taskmanagement.models.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllTasks();
    Task saveTask(Task task);
    List<Task> getTasksForCurrentUser();
    Task findTaskById(Long id);
    void deleteTask(Long id);
}
