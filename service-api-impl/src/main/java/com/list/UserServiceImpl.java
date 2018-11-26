package com.list;

import com.list.dto.UserDTO;
import com.list.entities.User;
import com.list.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();
        userRepository.findAll().forEach((user) -> {
            users.add(user.toDTO());
        });
        return users;
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        User user = new User();
        user.update(userDTO);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean userIdExists(Long id) {
        return userRepository.findById(id).isPresent();
    }


}
