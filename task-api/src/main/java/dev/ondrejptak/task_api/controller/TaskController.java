package dev.ondrejptak.task_api.controller;

import dev.ondrejptak.task_api.domain.CreateTaskRequest;
import dev.ondrejptak.task_api.domain.dto.CreateTaskRequestDto;
import dev.ondrejptak.task_api.domain.dto.TaskDto;
import dev.ondrejptak.task_api.domain.entity.Task;
import dev.ondrejptak.task_api.mapper.TaskMapper;
import dev.ondrejptak.task_api.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

	private final TaskService taskService;
	private final TaskMapper taskMapper;

	public TaskController(TaskService taskService, TaskMapper taskMapper) {
		this.taskService = taskService;
		this.taskMapper = taskMapper;
	}

	@PostMapping
	public ResponseEntity<TaskDto> createTask(@Valid @RequestBody CreateTaskRequestDto createTaskRequestDto) {
		CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDto);
		Task task = taskService.createTask(createTaskRequest);
		TaskDto createdTaskDto = taskMapper.toDto(task);
		return new ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<TaskDto>> getAllTasks() {
		List<Task> tasks = taskService.getAllTasks();
		List<TaskDto> taskDtos = tasks.stream()
				.map(taskMapper::toDto)
				.toList();
		return new ResponseEntity<>(taskDtos, HttpStatus.OK);
	}
}
