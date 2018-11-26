package com.list;

import com.list.dto.UserDTO;
import com.list.entities.JwtAuthenticationToken;
import com.list.security.JwtGenerator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenControllerImpl implements TokenController {
    private JwtGenerator jwtGenerator;

    public TokenControllerImpl(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }


    @Override
    public JwtAuthenticationToken generate(@RequestBody UserDTO userDTO) {
        JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(userDTO.getUserName(), userDTO.getPassword());
        jwtAuthenticationToken.setToken(jwtGenerator.generate(userDTO));
        return jwtAuthenticationToken;
    }
}
