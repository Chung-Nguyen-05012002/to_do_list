package com.example.to_do_list_be.service;

import com.example.to_do_list_be.entity.Task;
import com.example.to_do_list_be.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService {
    @Autowired
    private TaskRepository repo;

    public List<Task> getAll() {
        return repo.findAll();
    }

    public Task getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task create(Task task) {
        return repo.save(task);
    }

    public Task update(Long id, Task task) {
        Task existing = getById(id);
        existing.setTitle(task.getTitle());
        existing.setDescription(task.getDescription());
        existing.setDueDate(task.getDueDate());
        existing.setCompleted(task.isCompleted());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

