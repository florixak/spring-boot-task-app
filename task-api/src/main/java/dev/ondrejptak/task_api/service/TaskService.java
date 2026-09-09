package dev.ondrejptak.task_api.service;

import dev.ondrejptak.task_api.domain.CreateTaskRequest;
import dev.ondrejptak.task_api.domain.entity.Task;

import java.util.List;

public interface TaskService {
	Task createTask(CreateTaskRequest request);
	List<Task> getAllTasks();
}
