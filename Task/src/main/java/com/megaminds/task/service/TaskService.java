package com.megaminds.task.service;

import com.megaminds.task.dto.TaskAssignmentRequest;
import com.megaminds.task.dto.TaskAssignmentResponse;
import com.megaminds.task.dto.TaskRequest;
import com.megaminds.task.dto.TaskResponse;
import com.megaminds.task.entity.Task;
import com.megaminds.task.entity.TaskStatus;
import com.megaminds.task.entity.User;
import com.megaminds.task.exception.TaskException;
import com.megaminds.task.repository.TaskRepository;
import com.megaminds.task.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper;

    public TaskResponse createTask(TaskRequest request) {
        User assignedBy = userRepository.findById(request.assignedById())
                .orElseThrow(() -> new TaskException("Project Manager not found"));
        User assignedTo = userRepository.findById(request.assignedToId())
                .orElseThrow(() -> new TaskException("Ouvrier not found"));

        Task task = taskMapper.toTask(request, assignedBy, assignedTo);
        taskRepository.save(task);
        return taskMapper.toTaskResponse(task);
    }

    public TaskAssignmentResponse assignTask(TaskAssignmentRequest request) {
        Task task = taskRepository.findById(request.taskId())
                .orElseThrow(() -> new TaskException("Task not found"));
        User assignedTo = userRepository.findById(request.assignedToId())
                .orElseThrow(() -> new TaskException("Ouvrier not found"));

        task.setAssignedTo(assignedTo);
        taskRepository.save(task);

        return new TaskAssignmentResponse(
                task.getId(),
                assignedTo.getUsername(),
                "Task assigned successfully"
        );
    }
    public TaskResponse getTaskById(Integer taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskException("Task not found"));
        return taskMapper.toTaskResponse(task);
    }

    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toTaskResponse)
                .collect(Collectors.toList());
    }
    public TaskResponse updateTask(Integer taskId, TaskRequest request) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskException("Task not found"));

        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setStatus(TaskStatus.valueOf(request.status()));
        task.setDueDate(request.dueDate());

        taskRepository.save(task);
        return taskMapper.toTaskResponse(task);
    }

    public void deleteTask(Integer taskId) {
        taskRepository.deleteById(taskId);
    }
}
