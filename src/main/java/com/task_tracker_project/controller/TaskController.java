package com.task_tracker_project.controller;

import com.task_tracker_project.dto.TaskRequestDto;
import com.task_tracker_project.entity.Task;
import com.task_tracker_project.entity.TaskStatus;
import com.task_tracker_project.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public Task saveTask(@Valid @RequestBody TaskRequestDto task){
        return taskService.addTask(task);
    }

    @PostMapping("/add/bulk")
    public List<Task> saveBulktask(@RequestBody List<Task> tasks){
        return taskService.addBulkTask(tasks);
    }

    @GetMapping("/get/all")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @GetMapping("/get")
    public List<Task> getTaskByStatus(@RequestParam ("status") String status){
        return taskService.getTaskByStatus(status);
    }

    @PutMapping("/update")
    public Task updateTask(@RequestParam ("task_id") String id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

    @PatchMapping("/update/status")
    public ResponseEntity<Task> updateTaskStatus(@RequestParam ("task_id") String id,
                                                 @RequestParam ("task_status") TaskStatus status){
        return ResponseEntity.ok(taskService.updateStatus(id, status));
    }

    /*
    @PatchMapping("/{id}/status")
    public ResponseEntity<Task> updateTaskStatus(
            @PathVariable Long id,
            @RequestParam TaskStatus status) {

        return ResponseEntity.ok(taskService.updateStatus(id, status));
    }
     */

}