package com.akshitbaunthiyal.library.serviceImpl;

import com.akshitbaunthiyal.library.model.Course;
import com.akshitbaunthiyal.library.model.FullName;
import com.akshitbaunthiyal.library.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExampleServiceImpl implements ExampleService {

    @Override
    public Course get() {
        log.info("Inside get() method");
        Course noArgsConstructor = new Course();
        noArgsConstructor.setCourseName("Spring boot and Java");
        noArgsConstructor.setCourseType("Information technology");
        noArgsConstructor.setInstructorName(FullName.builder().firstName("Samarth").lastName("Narula").idNo(123).build());
        return noArgsConstructor;
    }

    @Override
    public Course customInfo(String courseName, String courseType, FullName fullName) {
        log.info("Inside customInfo() method");
        Course allArgsConstructor = new Course(courseName, courseType, fullName);
        return allArgsConstructor;
    }

}
