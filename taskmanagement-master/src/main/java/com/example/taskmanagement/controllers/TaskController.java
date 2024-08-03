package com.example.taskmanagement.controllers;

import com.example.taskmanagement.models.Task;
import com.example.taskmanagement.models.User;
import com.example.taskmanagement.repositories.UserRepository;
import com.example.taskmanagement.services.Impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    private final TaskServiceImpl taskService;

    @Autowired
    private UserRepository userRepository;

    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    // Get a task by ID
    @GetMapping("/{id}")
    public String getTaskById(@PathVariable Long id, Model model) throws Throwable {
        Task task = taskService.findTaskById(id);
        model.addAttribute("task", task);
        return "details";
    }

    // Show the form to create a new task
    @GetMapping("/tasks/create")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        return "create";
    }

    // Get all tasks for the current user
    @GetMapping()
    public String getAllTasksForCurrentUser(Model model) {
        List<Task> tasks = taskService.getTasksForCurrentUser();
        model.addAttribute("tasks", tasks);
        return "list";
    }

    // Create a new task
    @PostMapping
    public String createTask(@ModelAttribute Task task) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userRepository.findByUsername(currentPrincipalName).orElse(null);
        assert user != null;
        task.setUser(user);
        taskService.saveTask(task);
        return "redirect:/" + task.getId();
    }

    // Show the form to edit a task
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) throws Throwable {
        Task task = taskService.findTaskById(id);
        model.addAttribute("task", task);
        return "edit";
    }

    // Update a task
    @PostMapping("/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute("task") Task taskDetails) throws Throwable {
        Task task = taskService.findTaskById(id);
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        task.setPriority(taskDetails.getPriority());
        task.setDueDate(taskDetails.getDueDate());
        taskService.saveTask(task);
        return "redirect:/";
    }

    // Delete a task
    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }
}