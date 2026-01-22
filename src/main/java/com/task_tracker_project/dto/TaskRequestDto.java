package com.task_tracker_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskRequestDto {
    @NotBlank(message = "Title must not be empty")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String description;
}
