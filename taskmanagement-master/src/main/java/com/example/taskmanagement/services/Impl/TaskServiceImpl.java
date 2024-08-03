package com.example.taskmanagement.services.Impl;

import com.example.taskmanagement.models.Task;
import com.example.taskmanagement.repositories.TaskRepository;
import com.example.taskmanagement.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasksForCurrentUser() {
        // Implement logic to get tasks for the current user
        return null;
    }

    @Override
    public Task findTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> searchTasks(String keyword) {
        return taskRepository.searchTasks(keyword);
    }

    public List<Task> filterTasksByStatus(String status) {
        return taskRepository.filterTasksByStatus(status);
    }

    public List<Task> filterTasksByPriority(String priority) {
        return taskRepository.filterTasksByPriority(priority);
    }

    public List<Task> filterTasksByDueDate(LocalDateTime startDate, LocalDateTime endDate) {
        return taskRepository.filterTasksByDueDate(startDate, endDate);
    }
}
