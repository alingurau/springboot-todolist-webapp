package com.list;

import com.list.message.request.LoginForm;
import com.list.message.request.SignUpForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public interface AuthController {

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest);

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest);

    @GetMapping("/test")
    public String test();
}
