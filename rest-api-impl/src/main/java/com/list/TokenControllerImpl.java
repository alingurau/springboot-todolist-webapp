package com.list;

import com.list.config.JwtUser;
import com.list.security.JwtGenerator;
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
    public String generate(JwtUser jwtUser) {
        return jwtGenerator.generate(jwtUser);
    }
}
