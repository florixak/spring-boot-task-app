package dev.ondrejptak.task_api.domain;

import dev.ondrejptak.task_api.domain.entity.TaskPriority;
import dev.ondrejptak.task_api.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
		TaskPriority priority,
		TaskStatus status
) {
}
