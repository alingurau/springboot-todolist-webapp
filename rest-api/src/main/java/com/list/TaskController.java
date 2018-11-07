package com.list;

import com.list.dto.TaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public interface TaskController {

    @GetMapping("/tasks")
    List<TaskDTO> findAllTasks();

    @PostMapping("/addTask")
    ResponseEntity addTask(@RequestBody TaskDTO taskDTO);

    @PutMapping("/editTask/{id}")
    ResponseEntity editTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO);

    @DeleteMapping("/deleteTask/{id}")
    ResponseEntity deleteTask(@PathVariable Long id);
}
