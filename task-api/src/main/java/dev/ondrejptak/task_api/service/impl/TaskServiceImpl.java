package dev.ondrejptak.task_api.service.impl;

import dev.ondrejptak.task_api.domain.CreateTaskRequest;
import dev.ondrejptak.task_api.domain.entity.Task;
import dev.ondrejptak.task_api.domain.entity.TaskStatus;
import dev.ondrejptak.task_api.repository.TaskRepository;
import dev.ondrejptak.task_api.service.TaskService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

	private final TaskRepository taskRepository;

	public TaskServiceImpl(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public Task createTask(CreateTaskRequest request) {
		Instant now = Instant.now();
		Task task = new Task(null, request.title(), request.description(), request.dueDate(), TaskStatus.OPEN, request.priority(), now, now);

		return taskRepository.save(task);
	}

	@Override
	public List<Task> getAllTasks() {
		return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
	}
}
