package com.list.entities;

import com.list.dto.UserDTO;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@SQLDelete(sql = "UPDATE user SET delete_flag = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "delete_flag != 'DELETED'")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userName;
    private String role;
    private boolean deleteFlag;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public UserDTO toDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(this.firstName);
        userDTO.setLastName(this.lastName);
        userDTO.setEmail(this.email);
        userDTO.setPassword(this.password);
        userDTO.setRole(this.role);
        userDTO.setUserName(this.userName);
        userDTO.setDeleteFlag(this.deleteFlag);
        return userDTO;
    }

    public void update(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.role=userDTO.getRole();
        this.userName=userDTO.getUserName();
        this.deleteFlag=userDTO.isDeleteFlag();
    }

}
