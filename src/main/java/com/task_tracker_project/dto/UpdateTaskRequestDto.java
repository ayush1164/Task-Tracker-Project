package com.task_tracker_project.dto;

import com.task_tracker_project.entity.TaskStatus;
import lombok.Data;

@Data
public class UpdateTaskRequestDto {
    private String description;
    private TaskStatus status;
}
