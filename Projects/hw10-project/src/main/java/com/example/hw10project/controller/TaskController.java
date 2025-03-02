package com.example.hw10project.controller;

import com.example.hw10project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public String runTasks(@RequestParam(defaultValue = "10") int taskCount) {
        for (int i = 1; i <= taskCount; i++) {
            taskService.executeTask(i);
        }
        return "Tasks submitted";
    }
}
