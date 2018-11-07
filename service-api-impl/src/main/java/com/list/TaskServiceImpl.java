package com.list;

import com.list.dto.TaskDTO;
import com.list.entities.Task;
import com.list.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<TaskDTO> getAllTasks() {
        List<TaskDTO> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(task -> {
            tasks.add(task.toDTO());
        });
        return tasks;
    }

    @Override
    public void saveTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.update(taskDTO);
        taskRepository.save(task);
    }

    @Override
    public void updateTask(Long id, TaskDTO taskDTO) {
        taskRepository.findById(id);
        Task task = new Task();
        task.update(taskDTO);
        taskRepository.save(task);
    }

    @Override
    public boolean taskIdExists(Long id) {
        return taskRepository.findById(id).isPresent();
    }


}
