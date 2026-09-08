
package org.SmartWaste.controller;

import org.SmartWaste.Tasks;
import org.SmartWaste.service.TasksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")
public class TasksController
{
    private final TasksService service;

    public TasksController(TasksService service) {
        this.service = service;
    }


    @PostMapping("/submit")
    public ResponseEntity<String> submitTask(@RequestBody Tasks task) {
        try {
            String result = service.submitTask(task);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error publishing task " + e.getMessage());
        }
    }
    @GetMapping("/unassigned")
    public ResponseEntity<List<Tasks>> getUnassignedTasks() {
        try {
            List<Tasks> tasks = service.getUnassigned();
            return ResponseEntity.ok(tasks);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

