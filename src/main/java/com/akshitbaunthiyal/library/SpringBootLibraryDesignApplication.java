package com.akshitbaunthiyal.library;

import com.akshitbaunthiyal.library.model.Course;
import com.akshitbaunthiyal.library.model.FullName;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLibraryDesignApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLibraryDesignApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Runs before main()
//        All args constructor
//        Course course = new Course("Designing microservices with Spring Boot", "Information technology", "Samarth Narula");
//        System.out.println("All args constructor - " + course);

//        Telescoping constructor pattern
//        Course teleScopeDesignPattern = new Course("Learn creational design pattern", "Information technology");
//        System.out.println("Telescoping constructor - " + teleScopeDesignPattern);

//        Builder design pattern
//        Complex object creation
        Course builderDesignPattern = Course.builder().courseName("Spring builder")
                .courseType("I T")
                .instructorName(FullName.builder().firstName("Samarth").lastName("Narula").build())
                .build();
        System.out.println("Complex constructor + Builder design pattern - " + builderDesignPattern);
    }
}
