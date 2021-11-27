package com.akshitbaunthiyal.library.controller;

import com.akshitbaunthiyal.library.model.Course;
//import org.springframework.stereotype.Controller;
import com.akshitbaunthiyal.library.model.FullName;
import com.akshitbaunthiyal.library.serviceImpl.ExampleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class ExampleController {

    @Autowired
    ExampleServiceImpl exampleServiceImpl;

    @GetMapping("/info")
//    @ResponseBody
    public Course get() {
        return exampleServiceImpl.get();
    }

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello world!";
    }

    @PostMapping("/customInfo")
    public Course customInfo(String courseName, String courseType, FullName fullName) {
        return exampleServiceImpl.customInfo(courseName, courseType, fullName);
    }
}
