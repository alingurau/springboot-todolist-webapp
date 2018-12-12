package com.list.message.request;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignUpForm {

    @NotBlank
    @Size(min = 3, max = 60)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 60)
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Size(min = 3, max = 60)
    @Column(name = "username")
    private String username;

    @NotBlank
    @Size(max = 60)
    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    @Column(name = "password")
    private String password;

    @Column(name = "delete_flag")
    private boolean deleteFlag;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
