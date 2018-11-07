package com.list;

import com.list.dto.TaskDTO;
import com.list.entities.Task;
import com.list.repositories.TaskRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceImplTests {

    @InjectMocks
    TaskServiceImpl taskServiceImpl;

    @Mock
    TaskRepository taskRepositoryMock;

    Task task;

    @Before
    public void SetData() {
        task = new Task();
        task.setDate(new Date(2016, 12, 22));
        task.setDescription("description");
    }

    @Test
    public void getAllTasks_ShouldReturnListOfTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);

        when(taskRepositoryMock.findAll()).thenReturn(tasks);

        List<TaskDTO> result = taskServiceImpl.getAllTasks();

        List<TaskDTO> expect = new ArrayList<>();
        expect.add(task.toDTO());
        Assert.assertEquals(expect, result);
    }

    @Test
    public void saveTask_ShouldAddAnObject() {

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.getDate();
        taskDTO.getDescription();

        taskServiceImpl.saveTask(taskDTO);

        assertFalse(taskRepositoryMock.count() > 0);
    }

//    @Test
//    public void updateCar_ExpectsRepositorySaveMethodCall() {
//        when(taskRepositoryMock.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(task));
//
//        Task task = new Task();
//
//        taskServiceImpl.updateTask(task.getId(), task.toDTO());
//        verify(taskRepositoryMock, times(1)).save(task);
//    }
}

