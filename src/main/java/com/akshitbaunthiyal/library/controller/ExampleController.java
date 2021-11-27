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
        Course course = new Course();
        course.setCourseName("Spring boot and Java");
        course.setCourseType("Information technology");
        course.setInstructorName("Samarth Narula");
        return course;
    }

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello world!";
    }

    @PostMapping("/customInfo")
    public Course customInfo(String courseName, String courseType, String instructorName) {
        return new Course(courseName, courseType, instructorName);
    }
}
