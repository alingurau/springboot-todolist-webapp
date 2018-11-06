package com.list;

import com.list.dto.TaskDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task")
public interface TaskController {

    @GetMapping("/tasks")
    List<TaskDTO> findAllTasks();

    @GetMapping("/test")
    public String test();
}
