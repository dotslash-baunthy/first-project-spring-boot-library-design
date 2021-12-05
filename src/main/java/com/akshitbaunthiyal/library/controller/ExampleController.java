package com.akshitbaunthiyal.library.controller;

import com.akshitbaunthiyal.library.model.Course;
//import org.springframework.stereotype.Controller;
import com.akshitbaunthiyal.library.model.FullName;
import com.akshitbaunthiyal.library.service.ExampleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class ExampleController {

    @Autowired
    ExampleServiceImpl exampleServiceImpl;

    @GetMapping("/info")
//    @ResponseBody
    public Course getInfo() {
        return exampleServiceImpl.get();
    }

    @GetMapping("/hello")
    public String helloName(String name) {
        if (name == null) {
            return "Hello world!";
        } else {
            return "Hello " + name + "!";
        }
    }

    @PostMapping("/custominfo")
    public Course postInfo(String courseName, String courseType, FullName fullName) {
        return exampleServiceImpl.customInfo(courseName, courseType, fullName);
    }
}
