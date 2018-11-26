//package com.list.security;
//
//import com.list.dto.UserDTO;
//import com.list.entities.JwtUser;
//import com.list.entities.User;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import org.springframework.stereotype.Component;
//
//@Component
//public class JwtValidator {
//
//    private String secret = "youtube";
//
//    public UserDTO validate(String token) {
//        UserDTO userDTO = null;
//        try {
//            Claims body = Jwts.parser()
//                    .setSigningKey(secret)
//                    .parseClaimsJws(token)
//                    .getBody();
//
//            userDTO = new UserDTO();
//
//            userDTO.setUserName(body.getSubject());
//            userDTO.setRole((String) body.get("role"));
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return userDTO;
//    }
//}
