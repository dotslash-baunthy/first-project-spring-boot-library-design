package com.akshitbaunthiyal.library.model;

//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;

//@Data
//@Getter
//@Setter
//@ToString
public class Course {

    private String courseName;
    private String courseType;
    private String instructorName;

    public Course() {
    }

    public Course(String courseName, String courseType, String instructorName) {
        this.courseName = courseName;
        this.courseType = courseType;
        this.instructorName = instructorName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseType='" + courseType + '\'' +
                ", instructorName='" + instructorName + '\'' +
                '}';
    }
}
