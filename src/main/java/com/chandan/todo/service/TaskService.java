package com.chandan.todo.service;

import com.chandan.todo.entity.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);

    List<Task> getAllTask();

    Task getTaskById(Long id);

    Task updateTaskById(Task task, Long id);

    void deleteTaskById(Long id);
}
