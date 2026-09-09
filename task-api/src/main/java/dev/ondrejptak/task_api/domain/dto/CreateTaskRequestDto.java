package dev.ondrejptak.task_api.domain.dto;

import dev.ondrejptak.task_api.domain.entity.TaskPriority;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record CreateTaskRequestDto(
		@NotBlank(message = ERROR_MESSAGE_TITLE_LENGTH)
		@Length(max = 255, message = ERROR_MESSAGE_TITLE_LENGTH)
		String title,
		@Length(max = 1000, message = ERROR_MESSAGE_DESCRIPTION_LENGTH)
		@Nullable
		String description,
		@FutureOrPresent(message = ERROR_MESSAGE_DUE_DATE)
		@Nullable
		LocalDate dueDate,
		@NotNull(message = ERROR_MESSAGE_PRIORITY)
		TaskPriority priority
) {
	private static final String ERROR_MESSAGE_TITLE_LENGTH = "Title must be between 1 and 255 characters";

	private static final String ERROR_MESSAGE_DESCRIPTION_LENGTH = "Description must be at most 1000 characters";

	private static final String ERROR_MESSAGE_DUE_DATE = "Due date must be in the present or future";

	private static final String ERROR_MESSAGE_PRIORITY = "Priority must not be null";
}
