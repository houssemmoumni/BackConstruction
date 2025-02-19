package com.megaminds.task.service;

import com.megaminds.task.dto.TaskRequest;
import com.megaminds.task.dto.TaskResponse;
import com.megaminds.task.entity.Task;
import com.megaminds.task.entity.TaskStatus;
import com.megaminds.task.entity.User;
import org.springframework.stereotype.Service;

@Service
public class TaskMapper {
    public Task toTask(TaskRequest request, User assignedBy, User assignedTo) {
        return Task.builder()
                .title(request.title()) // Use title() instead of getTitle()
                .description(request.description()) // Use description() instead of getDescription()
                .status(TaskStatus.PENDING) // Default status for new tasks
                .dueDate(request.dueDate()) // Use dueDate() instead of getDueDate()
                .assignedBy(assignedBy)
                .assignedTo(assignedTo)
                .build();
    }

    public TaskResponse toTaskResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus().name(),
                task.getDueDate(),
                task.getAssignedBy().getUsername(),
                task.getAssignedTo().getUsername()
        );
    }
}
