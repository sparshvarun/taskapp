package com.example.taskmanagement.repositories;

import com.example.taskmanagement.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserUsername(String username);

    @Query("SELECT t FROM Task t WHERE t.title LIKE %:keyword% OR t.description LIKE %:keyword%")
    List<Task> searchTasks(@Param("keyword") String keyword);

    @Query("SELECT t FROM Task t WHERE t.status = :status")
    List<Task> filterTasksByStatus(@Param("status") String status);

    @Query("SELECT t FROM Task t WHERE t.priority = :priority")
    List<Task> filterTasksByPriority(@Param("priority") String priority);

    @Query("SELECT t FROM Task t WHERE t.dueDate BETWEEN :startDate AND :endDate")
    List<Task> filterTasksByDueDate(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
