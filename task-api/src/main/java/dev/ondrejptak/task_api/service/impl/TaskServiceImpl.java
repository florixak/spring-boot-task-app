package dev.ondrejptak.task_api.service.impl;

import dev.ondrejptak.task_api.domain.CreateTaskRequest;
import dev.ondrejptak.task_api.domain.UpdateTaskRequest;
import dev.ondrejptak.task_api.domain.entity.Task;
import dev.ondrejptak.task_api.domain.entity.TaskStatus;
import dev.ondrejptak.task_api.exception.TaskNotFoundException;
import dev.ondrejptak.task_api.repository.TaskRepository;
import dev.ondrejptak.task_api.service.TaskService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

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

	@Override
	public Task updateTask(UUID id, UpdateTaskRequest request) {
		Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));

		task.setTitle(request.title());
		task.setDescription(request.description());
		task.setDueDate(request.dueDate());
		task.setPriority(request.priority());
		task.setStatus(request.status());
		task.setUpdatedAt(Instant.now());

		return taskRepository.save(task);
	}

	@Override
	public void deleteTask(UUID id) {
		if (!taskRepository.existsById(id)) {
			throw new TaskNotFoundException(id);
		}
		taskRepository.deleteById(id);
	}
}
