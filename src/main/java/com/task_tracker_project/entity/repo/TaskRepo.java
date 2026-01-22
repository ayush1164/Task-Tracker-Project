package com.task_tracker_project.entity.repo;

import com.task_tracker_project.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, String> {
    List<Task> findByStatus(String status);
}
