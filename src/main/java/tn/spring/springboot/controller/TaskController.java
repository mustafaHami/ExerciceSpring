package tn.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entity.Tasks;
import tn.spring.springboot.service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Tasks> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<Tasks> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/create")
    public Tasks createTask(@RequestBody Tasks task) {
        return taskService.createTask(task);
    }

    @PutMapping("/update/{id}")
    public Tasks updateTask(@PathVariable Long id, @RequestBody Tasks updatedTask) {
        return taskService.updateTask(id, updatedTask);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
