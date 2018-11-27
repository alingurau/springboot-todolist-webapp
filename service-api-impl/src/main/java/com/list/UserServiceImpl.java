package com.list;

import com.list.dto.TaskDTO;
import com.list.dto.UserDTO;
import com.list.entities.Task;
import com.list.entities.User;
import com.list.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            users.add(user.toDTO());
        });
            return users;
    }

//    @Override
//    public List<UserDTO> getAllUsers() {
//        return userRepository.findAll()
//                .stream()
//                .map(User::toDTO)
//                .collect(Collectors.toList());
//    }

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
