package com.list.dto;

import java.util.Date;

public class TaskDTO {

    private Date date;
    private String description;

    public TaskDTO(){}

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
}
