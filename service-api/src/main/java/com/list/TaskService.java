package com.list;

import com.list.dto.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    List<TaskDTO> getAllTasks();

    void saveTask(TaskDTO taskDTO);

    public TaskDTO updateTask(TaskDTO taskDTO, Long id);

    void deleteTask(Long id);

    public boolean taskIdExists(Long id);

}
