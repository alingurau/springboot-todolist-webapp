package com.list;

import com.list.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskControllerImpl implements TaskController {

    @Autowired
    TaskService taskService;

    @Override
    public List<TaskDTO> findAllTasks() {
        return taskService.getAllTasks();
    }

    @Override
    public String test() {
        return "This is a test";
    }
}
