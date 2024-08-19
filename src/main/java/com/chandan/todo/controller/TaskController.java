package com.chandan.todo.controller;

import com.chandan.todo.dto.TaskDto;
import com.chandan.todo.entity.Task;
import com.chandan.todo.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")

public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task task1 = taskService.createTask(task);
        return new ResponseEntity<>(task1, HttpStatus.CREATED);

    }

    @GetMapping
    public List<Task> getAllTask() {
        return taskService.getAllTask();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Task> updateTaskById(@PathVariable Long id, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTaskById(task, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
