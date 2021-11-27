package com.akshitbaunthiyal.library;

import com.akshitbaunthiyal.library.model.Course;
import com.akshitbaunthiyal.library.model.FullName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringBootLibraryDesignApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLibraryDesignApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Runs before main()
        Course builderDesignPattern = Course.builder().courseName("Spring builder")
                .courseType("I T")
                .instructorName(FullName.builder().firstName("Samarth").lastName("Narula").build())
                .build();
        log.info("Complex constructor + Builder design pattern -> {}", builderDesignPattern);
    }
}
