package com.backend.controllers;


import com.backend.dto.impl.AuthDto;
import com.backend.dto.impl.UserDto;
import com.backend.mapper.UserHeavyMapper;
import com.backend.model.UserEntity;
import com.backend.security.jwt.JwtTokenProvider;
import com.backend.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * AuthenticationController - контроллер для авторизации пользователя
 */
@RestController
@RequestMapping(value = "/user/auth/")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;
    private final UserHeavyMapper userHeavyMapper;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager,
                                    JwtTokenProvider jwtTokenProvider,
                                    UserService userService,
                                    UserHeavyMapper userHeavyMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.userHeavyMapper = userHeavyMapper;
    }

    @Operation(
            summary = "Авторизация пользователя",
            description = "Передаёшь логин и пароль, " +
                          "получаешь токен и логин обратно"
    )
    @PostMapping("login")
    public AuthDto.Response.AuthUser login(@RequestBody AuthDto.Request.AuthUser authDto) {
        try {
            String userName = authDto.getUserName();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, authDto.getPassword()));
            UserEntity user = userService.findByUserName(userName);

            if (Objects.isNull(user)) {
                throw new UsernameNotFoundException("User with userName: " + userName + " not found");
            }
            String token = jwtTokenProvider.createToken(userName, user.getRoles());
            return new AuthDto.Response.AuthUser(token, userName);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @Operation(
            summary = "Регистрация пользователя",
            description = "Передаёшь логин и пароль, " +
                    "получаешь токен и логин обратно"
    )
    @PostMapping("signUp")
    public UserDto.Response.UserHeavy signUP(@RequestBody UserDto.Request.CreateUser newUser) {
        return userHeavyMapper.toDto(userService.create(userHeavyMapper.toEntity(newUser)));
    }
}
