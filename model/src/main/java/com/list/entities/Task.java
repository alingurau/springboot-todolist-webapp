package com.list.entities;

import com.list.dto.TaskDTO;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@SQLDelete(sql = "UPDATE task SET delete_flag = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "delete_flag != 'DELETED'")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private String description;
    private boolean deleteFlag;

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

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public TaskDTO toDTO() {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setDate(this.date);
        taskDTO.setDescription(this.description);
        taskDTO.setDeleteFlag(this.deleteFlag);

        return taskDTO;
    }

    public void update(TaskDTO taskDTO) {
        this.date = taskDTO.getDate();
        this.description = taskDTO.getDescription();
        this.deleteFlag = taskDTO.isDeleteFlag();
    }
}
