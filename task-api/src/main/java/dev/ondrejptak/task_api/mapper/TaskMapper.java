package dev.ondrejptak.task_api.mapper;

import dev.ondrejptak.task_api.domain.CreateTaskRequest;
import dev.ondrejptak.task_api.domain.UpdateTaskRequest;
import dev.ondrejptak.task_api.domain.dto.CreateTaskRequestDto;
import dev.ondrejptak.task_api.domain.dto.TaskDto;
import dev.ondrejptak.task_api.domain.dto.UpdateTaskRequestDto;
import dev.ondrejptak.task_api.domain.entity.Task;

public interface TaskMapper {

	CreateTaskRequest fromDto(CreateTaskRequestDto dto);

	UpdateTaskRequest fromDto(UpdateTaskRequestDto dto);

	TaskDto toDto(Task task);


}
