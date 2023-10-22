package me.dio.controller;

import me.dio.domain.Tasks;
import me.dio.service.TasksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/tasks")
public class TaskesController {

    private final TasksService tasksService;

    public TaskesController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tasks> findById(@PathVariable Long id ){
        var task = tasksService.findByIdTasks(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<Tasks> createToTask(@RequestBody Tasks tasks){
        var task = tasksService.createToTasks(tasks);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tasks.getId())
                .toUri();
        return ResponseEntity.created(location).body(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        tasksService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
