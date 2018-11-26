//package com.list.security;
//
//
//import com.list.dto.UserDTO;
//import com.list.entities.JwtAuthenticationToken;
//import com.list.entities.JwtUser;
//import com.list.entities.JwtUserDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
//
//    @Autowired
//    private JwtValidator validator;
//
//    @Override
//    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
//
//    }
//
//    @Override
//    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
//        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
//        String token = jwtAuthenticationToken.getToken();
//
//        UserDTO userDTO = validator.validate(token);
//
//        if (userDTO == null) {
//            throw new RuntimeException("JWT Token is incorrect");
//        }
//
//        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(userDTO.getRole());
//        return new JwtUserDetails(userDTO.getUserName(), userDTO.getPassword(),
//                token,
//                grantedAuthorities);
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
//    }
//}
