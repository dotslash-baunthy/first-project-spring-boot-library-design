package com.akshitbaunthiyal.library.service;

import com.akshitbaunthiyal.library.model.Course;
import com.akshitbaunthiyal.library.model.FullName;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {

    @Override
    public Course get() {
        Course noArgsConstructor = new Course();
        noArgsConstructor.setCourseName("Spring boot and Java");
        noArgsConstructor.setCourseType("Information technology");
        noArgsConstructor.setInstructorName(FullName.builder().firstName("Samarth").lastName("Narula").idNo(123).build());
        return noArgsConstructor;
    }

    @Override
    public Course customInfo(String courseName, String courseType, FullName fullName) {
        Course allArgsConstructor = new Course(courseName, courseType, fullName);
        return allArgsConstructor;
    }

}
