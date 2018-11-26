package com.list;

import com.list.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/user")
public interface UserController {

    @GetMapping("/users")
    List<UserDTO> findAllUsers();

    @PostMapping("/add")
    ResponseEntity addUser(@RequestBody UserDTO userDTO);

    @DeleteMapping("/deleteUser/{id}")
    ResponseEntity deleteUser(@PathVariable Long id);
}
