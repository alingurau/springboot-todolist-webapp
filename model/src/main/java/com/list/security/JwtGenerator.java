package com.list.security;

import com.list.dto.UserDTO;
import com.list.entities.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {
    public String generate(UserDTO userDTO) {

        Claims claims = Jwts.claims().setSubject(userDTO.getUserName());
        claims.put("password", String.valueOf(userDTO.getPassword()));
        claims.put("role", userDTO.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }
}
