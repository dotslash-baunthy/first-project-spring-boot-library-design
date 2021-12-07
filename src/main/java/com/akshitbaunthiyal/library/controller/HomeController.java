package com.akshitbaunthiyal.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String getHome() {
        return "<h>Logged in successfully</h>";
    }
}
