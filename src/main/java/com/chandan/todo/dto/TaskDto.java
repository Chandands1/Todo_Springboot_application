package com.chandan.todo.dto;

import com.chandan.todo.entity.TaskStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
