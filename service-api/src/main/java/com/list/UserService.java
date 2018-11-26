package com.list;

import com.list.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserDTO> getAllUsers();

    void saveUser(UserDTO userDTO);

    void deleteUser(Long id);

    boolean userIdExists(Long id);
}
