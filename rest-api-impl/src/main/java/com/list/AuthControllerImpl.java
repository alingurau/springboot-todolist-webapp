package com.list;

import com.list.entities.Role;
import com.list.entities.User;
import com.list.enums.RoleName;
import com.list.message.request.LoginForm;
import com.list.message.request.SignUpForm;
import com.list.message.response.JwtResponse;
import com.list.repositories.RoleRepository;
import com.list.repositories.UserRepository;
import com.list.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
public class AuthControllerImpl implements AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @Override
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }


    @Override
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!", HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>("Fail -> Email is already in use!", HttpStatus.BAD_REQUEST);
        }

        User user = new User(signUpRequest.getFirstName(), signUpRequest.getLastName(),
                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()), signUpRequest.getUsername(), signUpRequest.isDeleteFlag());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User role not found"));
                    roles.add(adminRole);
                    break;
                case "pm":
                    Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User role not found"));
                    roles.add(pmRole);
                    break;
                default:
                    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not found"));
                    roles.add(userRole);
            }
        });
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok().body("User registered successfully!");
    }

    @Override
    public String test() {
        return "test";
    }


}
