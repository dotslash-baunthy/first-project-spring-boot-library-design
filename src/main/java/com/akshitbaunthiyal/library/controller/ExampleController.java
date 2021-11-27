package com.akshitbaunthiyal.library.controller;

import com.akshitbaunthiyal.library.model.Course;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class ExampleController {

    @GetMapping("/info")
//    @ResponseBody
    public Course get() {
        Course noArgsConstructor = new Course();
        noArgsConstructor.setCourseName("Spring boot and Java");
        noArgsConstructor.setCourseType("Information technology");
        noArgsConstructor.setInstructorName("Samarth Narula");
        return noArgsConstructor;
    }

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello world!";
    }

    @PostMapping("/customInfo")
    public Course customInfo(String courseName, String courseType, String instructorName) {
        Course allArgsConstructor = new Course(courseName, courseType, instructorName);
        return allArgsConstructor;
    }
}
