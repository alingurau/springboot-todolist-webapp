package com.list;

import com.list.dto.TaskDTO;
import com.list.entities.Task;
import com.list.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;


    @Override
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(Task::toDTO)
                .collect(Collectors.toList());
    }








    @Override
    public void saveTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.update(taskDTO);
        taskRepository.save(task);
    }

    @Override
    public TaskDTO updateTask(TaskDTO taskDTO, Long id) {
        final Optional<Task> dbTask = taskRepository.findById(id);

        if (dbTask.isPresent()) {
            Task task = dbTask.get();
            task.setDate(taskDTO.getDate());
            task.setDescription(taskDTO.getDescription());
            return taskRepository.save(task).toDTO();
        }
        return taskDTO;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public boolean taskIdExists(Long id) {
        return taskRepository.findById(id).isPresent();
    }
}
