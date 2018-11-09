package com.list;

import com.list.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity addTask(TaskDTO taskDTO) {
        if (taskDTO != null) {
            taskService.saveTask(taskDTO);
            return new ResponseEntity("TASK ADDED", HttpStatus.CREATED);
        }
        return new ResponseEntity("INVALID INPUT", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity editTask(Long id, TaskDTO taskDTO) {
        if (taskService.taskIdExists(id)) {
            taskService.updateTask(taskDTO,id);
            return new ResponseEntity("TASK EDITED", HttpStatus.OK);
        }
        return new ResponseEntity("INVALID INPUT", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity deleteTask(Long id) {
        if(taskService.taskIdExists(id)){

            taskService.deleteTask(id);
            return new ResponseEntity("TASK DELETED",HttpStatus.OK);
        }
        return new ResponseEntity("INVALID REQUEST", HttpStatus.BAD_REQUEST);
    }

}
