package com.task_tracker_project.service;

import com.task_tracker_project.dto.TaskRequestDto;
import com.task_tracker_project.entity.Task;
import com.task_tracker_project.entity.TaskStatus;
import com.task_tracker_project.entity.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class TaskService {

    // geting current date and time
//    LocalDateTime dateTime = LocalDateTime.now(); // There is no need for it, coz the @@CreatedDate handle it by own in task,java by JPA auditing

    @Autowired
    private TaskRepo taskRepo;

    // how to get random String
    // There is no need for it, coz the @@CreatedDate handle it by own in task,java by JPA auditing
    /*
    public String getRandomStr() {
        String[] strArr = {"todo", "in-progress", "done"};
        Random random = new Random();
        int randomIndex = random.nextInt(strArr.length);
        return strArr[randomIndex];
    }
     */

    public Task addTask(TaskRequestDto task) {
        Task task1 = new Task();
        task1.setId(UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        task1.setStatus(TaskStatus.TODO);
        task1.setDescription(task.getDescription());
        return taskRepo.save(task1);
    }

    public List<Task> addBulkTask(List<Task> tasks) {
        return taskRepo.saveAll(tasks);
    }

    public List<Task> getTasks() {
        return taskRepo.findAll();
    }

    public List<Task> getTaskByStatus(String status) {
        return taskRepo.findByStatus(status);
    }

    public Task updateTask(String id, Task task) {

//        Task task1 = taskRepo.findById(Long.valueOf(id)).get();
        Task task1 = taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task1.setId(task.getId());
        task1.setDescription(task.getDescription());
        task1.setStatus(task.getStatus());
        task1.setCreatedAt(task.getCreatedAt());
        task1.setUpdateAt(task.getUpdateAt());

        return taskRepo.save(task);
    }

    public Task updateStatus(String id, TaskStatus status) {
        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        if (task.getStatus() == TaskStatus.DONE) {
            throw new IllegalStateException("Completed tasks cannot be changed");
        }
        task.setStatus(status);   // overwrite enum
        return taskRepo.save(task);
    }

//    public Task updateStatus(String id, String status) {
//
//        Task task1 = taskRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Task not found"));
//
//        task1.setStatus(status);
//
//        return taskRepo.save(task1);
//    }
}

