package com.akshitbaunthiyal.library.controller;

import com.akshitbaunthiyal.library.model.AkshitBaunthiyal;
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
    public AkshitBaunthiyal get() {
        AkshitBaunthiyal akshitBaunthiyal = new AkshitBaunthiyal();
        akshitBaunthiyal.setCourseName("Learn controllers in Spring Boot");
        akshitBaunthiyal.setCourseType("Information technology");
        akshitBaunthiyal.setInstructorName("Samarth Narula");
        return akshitBaunthiyal;
    }

    @PostMapping("/customInfo")
    public AkshitBaunthiyal customInfo(String courseName, String courseType, String instructorName) {
        AkshitBaunthiyal akshitBaunthiyal = new AkshitBaunthiyal();
        akshitBaunthiyal.setCourseName(courseName);
        akshitBaunthiyal.setCourseType(courseType);
        akshitBaunthiyal.setInstructorName(instructorName);
        return akshitBaunthiyal;
    }
}
