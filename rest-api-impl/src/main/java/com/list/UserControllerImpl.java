package com.list;

import com.list.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public List<UserDTO> findAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public ResponseEntity addUser(@RequestBody UserDTO userDTO) {
        if (userDTO != null) {
            userService.saveUser(userDTO);
            return new ResponseEntity("USER ADDED", HttpStatus.CREATED);
        }
        return new ResponseEntity("INVALID INPUT", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity deleteUser(Long id) {
        if (userService.userIdExists(id)) {
            userService.deleteUser(id);
            return new ResponseEntity("USER DELETED", HttpStatus.OK);
        }
        return new ResponseEntity("INVALID REQUEST", HttpStatus.BAD_REQUEST);
    }
}
