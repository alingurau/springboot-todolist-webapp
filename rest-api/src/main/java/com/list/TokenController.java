package com.list;

import com.list.dto.UserDTO;
import com.list.entities.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/token")
public interface TokenController {
    @PostMapping
    @ResponseBody
    JwtAuthenticationToken generate(@RequestBody final UserDTO userDTO);
}
