package dev.ondrejptak.task_api.domain.dto;

import dev.ondrejptak.task_api.domain.entity.TaskPriority;
import dev.ondrejptak.task_api.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto (
		UUID id,
		String title,
		String description,
		LocalDate dueDate,
		TaskPriority priority,
		TaskStatus status
) {
}
