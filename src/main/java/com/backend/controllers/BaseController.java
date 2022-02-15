package com.backend.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

/**
* Абстрактный контроллер
* для обработки обработки запросов
* @author Krll
*/

@AllArgsConstructor
public abstract class BaseController {
    @GetMapping
    public String test(){
        return "TESTSSS";
    }

}
