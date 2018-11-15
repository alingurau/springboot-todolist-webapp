package com.list;

import com.list.config.JwtUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public interface TokenController {
    @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser);
}
