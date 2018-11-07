package com.list;

import com.list.dto.TaskDTO;
import com.list.entities.Task;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TaskControllerImplTest {

    @InjectMocks
    TaskControllerImpl taskControllerImpl;

    @Mock
    TaskService taskServiceMock;

    private TaskDTO task;

    @Before
    public void SetUp() {
        task = new TaskDTO();
        task.setDate(new Date(2014, 02, 01));
        task.setDescription("This is a description");
    }

    @Test
    public void getAllTasks_ShouldReturnListOfTasks() {
        List<TaskDTO> tasks = new ArrayList<>();
        tasks.add(task);

        when(taskServiceMock.getAllTasks()).thenReturn(tasks);

        List<TaskDTO> result = taskControllerImpl.findAllTasks();
        Assert.assertEquals(tasks, result);
    }

    @Test
    public void addTask_ShouldReturnHttpStatusCreated() {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.getDate();
        taskDTO.getDescription();

        ResponseEntity result = taskControllerImpl.addTask(taskDTO);

        ResponseEntity expect = new ResponseEntity("TASK ADDED", HttpStatus.CREATED);

        assertEquals(result, expect);
    }

    @Test
    public void addTask_ShouldReturnHttpStatusBadRequest() {
        ResponseEntity result = taskControllerImpl.addTask(null);

        ResponseEntity expect = new ResponseEntity("INVALID INPUT", HttpStatus.BAD_REQUEST);
        assertEquals(result, expect);
    }

    @Test
    public void editTask_ShouldReturnHttpStatusOK() {
        Task task = new Task();
        TaskDTO taskDTO = new TaskDTO();
        when(taskServiceMock.taskIdExists(task.getId())).thenReturn(true);

        ResponseEntity result = taskControllerImpl.editTask(task.getId(), taskDTO);

        ResponseEntity expect = new ResponseEntity("TASK EDITED", HttpStatus.OK);
        assertEquals(result, expect);
    }

    @Test
    public void editTask_ShouldReturnHttpStatusBadRequest() {
        Task task = new Task();
        TaskDTO taskDTO = new TaskDTO();

        ResponseEntity result = taskControllerImpl.editTask(task.getId(), taskDTO);

        ResponseEntity expect = new ResponseEntity("INVALID INPUT", HttpStatus.BAD_REQUEST);
        assertEquals(result, expect);
    }

    @Test
    public void deleteTask_ShouldReturnHttpStatusOk() {
        Task task = new Task();

        when(taskServiceMock.taskIdExists(task.getId())).thenReturn(true);
        ResponseEntity result = taskControllerImpl.deleteTask(task.getId());

        ResponseEntity expect = new ResponseEntity("TASK DELETED", HttpStatus.OK);
        assertEquals(result, expect);
    }

    @Test
    public void deleteTask_ShouldReturnHttpStatusBadRequest() {
        Task task = new Task();

        when(taskServiceMock.taskIdExists(task.getId())).thenReturn(false);
        ResponseEntity result = taskControllerImpl.deleteTask(task.getId());

        ResponseEntity expect = new ResponseEntity("INVALID REQUEST", HttpStatus.BAD_REQUEST);
        assertEquals(result, expect);
    }

}
