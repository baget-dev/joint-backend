package com.backend.security;

import com.backend.model.UserEntity;
import com.backend.security.jwt.JwtUser;
import com.backend.security.jwt.JwtUserFactory;
import com.backend.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = userService.findByUserName(userName);

        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("User with name: " + userName + " not found");
        }
        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN loadUserByUsername - user with userName: {} successfully loaded", userName);
        return jwtUser;
    }
}
