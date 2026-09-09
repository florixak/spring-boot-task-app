package dev.ondrejptak.task_api.mapper.impl;

import dev.ondrejptak.task_api.domain.CreateTaskRequest;
import dev.ondrejptak.task_api.domain.UpdateTaskRequest;
import dev.ondrejptak.task_api.domain.dto.CreateTaskRequestDto;
import dev.ondrejptak.task_api.domain.dto.TaskDto;
import dev.ondrejptak.task_api.domain.dto.UpdateTaskRequestDto;
import dev.ondrejptak.task_api.domain.entity.Task;
import dev.ondrejptak.task_api.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {

	@Override
	public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
		return new CreateTaskRequest(dto.title(), dto.description(), dto.dueDate(), dto.priority());
	}

	@Override
	public UpdateTaskRequest fromDto(UpdateTaskRequestDto dto) {
		return new UpdateTaskRequest(dto.title(), dto.description(), dto.dueDate(), dto.priority(), dto.status());
	}

	@Override
	public TaskDto toDto(Task task) {
		return new TaskDto(task.getId(), task.getTitle(), task.getDescription(), task.getDueDate(), task.getPriority(), task.getStatus());
	}
}
