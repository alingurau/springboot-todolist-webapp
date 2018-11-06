package com.list;

import com.list.dto.TaskDTO;
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
        task.setDate(new Date(2014,02,01));
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

}
