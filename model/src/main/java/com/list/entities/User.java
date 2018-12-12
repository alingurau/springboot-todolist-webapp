package com.list.entities;

import com.list.dto.UserDTO;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"username"}),
                @UniqueConstraint(columnNames = {"email"})
        })
@SQLDelete(sql = "UPDATE user SET delete_flag = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "delete_flag != 'DELETED'")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 100)
    @Column(name = "last_name")
    private String lastName;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(min = 6, max = 100)
    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "role")
    private Set<Role> roles = new HashSet<>();

    @Column(name = "delete_flag")
    private boolean deleteFlag;

    public User() {

    }

    public User(String firstName, String lastName, String email, String password, String username,boolean deleteFlag) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.deleteFlag = deleteFlag;
    }


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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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
        userDTO.setRoles(this.roles);
        userDTO.setUserName(this.username);
        userDTO.setDeleteFlag(this.deleteFlag);
        return userDTO;
    }

    public void update(UserDTO userDTO) {
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.roles = userDTO.getRoles();
        this.username = userDTO.getUserName();
        this.deleteFlag = userDTO.isDeleteFlag();
    }

}
