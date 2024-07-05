package com.ojas.crashCourse.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("sayhello")
    public String sayHello() {
        return "say hello";
    }

    @PostMapping("/{user}/say-Hello")
    public String sayHello(@PathVariable String user) {
        return "Hello " + user;
    }


}
