package com.list.entities;

import com.list.dto.TaskDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private Date date;
    @NotNull
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskDTO toDTO() {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setDate(this.date);
        taskDTO.setDescription(this.description);

        return taskDTO;
    }

    public void update(TaskDTO taskDTO) {
        this.date = taskDTO.getDate();
        this.description = taskDTO.getDescription();
    }
}
