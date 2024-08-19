package com.chandan.todo.service.impl;

import com.chandan.todo.entity.Task;
import com.chandan.todo.entity.TaskStatus;
import com.chandan.todo.repository.TaskRepository;
import com.chandan.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setStatus(TaskStatus.PENDING);

        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(()->  new RuntimeException("The Task not found!"));
    }

    @Override
    public Task updateTaskById(Task task, Long id) {

        Task task1 =  getTaskById(id);
        task1.setTitle(task.getTitle());
        task1.setDescription(task.getDescription());
        task1.setStatus(task.getStatus());
        task1.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(task1);
    }

    @Override
    public void deleteTaskById(Long id) {

        Task task = getTaskById(id);
         taskRepository.delete(task);
    }

}
