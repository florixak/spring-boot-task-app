package dev.ondrejptak.task_api.domain;

import dev.ondrejptak.task_api.domain.entity.TaskPriority;

import java.time.LocalDate;

public record CreateTaskRequest(String title, String description, LocalDate dueDate, TaskPriority priority) {
}
