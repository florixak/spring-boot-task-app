package dev.ondrejptak.task_api.mapper;

import dev.ondrejptak.task_api.domain.CreateTaskRequest;
import dev.ondrejptak.task_api.domain.dto.CreateTaskRequestDto;
import dev.ondrejptak.task_api.domain.dto.TaskDto;
import dev.ondrejptak.task_api.domain.entity.Task;

public interface TaskMapper {

	CreateTaskRequest fromDto(CreateTaskRequestDto dto);

	TaskDto toDto(Task task);
}
