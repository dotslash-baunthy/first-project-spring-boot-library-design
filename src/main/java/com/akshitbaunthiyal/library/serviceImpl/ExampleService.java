package com.akshitbaunthiyal.library.serviceImpl;

import com.akshitbaunthiyal.library.model.Course;
import com.akshitbaunthiyal.library.model.FullName;

public interface ExampleService {
    Course get();

    Course customInfo(String courseName, String courseType, FullName fullName);
}
