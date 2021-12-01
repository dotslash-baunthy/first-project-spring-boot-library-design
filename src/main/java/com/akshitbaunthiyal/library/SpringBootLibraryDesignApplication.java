package com.akshitbaunthiyal.library;

//import com.akshitbaunthiyal.library.model.AkshitBaunthiyal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLibraryDesignApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLibraryDesignApplication.class, args);
        System.out.println("Hello spring boot!");
    }

    @Override
    public void run(String... args) throws Exception {
//
////        AkshitBaunthiyal akshitBaunthiyal = new AkshitBaunthiyal();
////
////        akshitBaunthiyal.setCourseName("Spring with Java");
////        akshitBaunthiyal.setCourseType("Information technology");
////        akshitBaunthiyal.setInstructorName("Samarth Narula");
////
////        System.out.println(akshitBaunthiyal.toString());
    }
}
