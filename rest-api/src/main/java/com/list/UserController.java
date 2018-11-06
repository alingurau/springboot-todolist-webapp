package com.list;

import com.list.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public interface   UserController {

    @GetMapping("/users")
    List<UserDTO> findAllUsers();
}
