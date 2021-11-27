package com.akshitbaunthiyal.library.service;

import com.akshitbaunthiyal.library.model.Course;
import com.akshitbaunthiyal.library.model.FullName;
import org.springframework.stereotype.Component;

@Component
public interface ExampleService {
    Course get();

    Course customInfo(String courseName, String courseType, FullName fullName);
}
