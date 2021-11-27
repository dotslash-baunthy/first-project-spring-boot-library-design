package com.akshitbaunthiyal.library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    private String courseName;
    private String courseType;
//    private String instructorName;
    private FullName instructorName;
    public Course(String courseName) {
        this.courseName = courseName;
    }

    public Course(String courseName, String courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

}
