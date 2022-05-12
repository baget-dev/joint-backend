package com.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("${server.userEndPoint}")
public class CommonController {
    @GetMapping
    public String test(){
        return "Сервер запущен : " + LocalDateTime.now();
    }
}
