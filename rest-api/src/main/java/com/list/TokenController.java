package com.list;

import com.list.config.JwtUser;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/token")
public interface TokenController {
    @PostMapping
    String generate(@RequestBody final JwtUser jwtUser);
}
