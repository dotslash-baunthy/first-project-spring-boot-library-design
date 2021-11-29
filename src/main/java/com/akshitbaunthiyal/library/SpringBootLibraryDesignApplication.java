package com.akshitbaunthiyal.library;

import com.akshitbaunthiyal.library.model.Course;
import com.akshitbaunthiyal.library.model.FullName;
import com.akshitbaunthiyal.library.service.LibraryReadServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.akshitbaunthiyal.library.entity")
@Slf4j
public class SpringBootLibraryDesignApplication implements CommandLineRunner {

    @Autowired
    LibraryReadServiceImpl libraryReadService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLibraryDesignApplication.class, args);
    }

    @Override

    public void run(String... args) throws Exception {
//        Runs before main()
        log.info("Fetch all libraries -> {}" + libraryReadService.getAllLibrary());
        log.info("Fetch all libraries with no books -> {}" + libraryReadService.getAllLibrariesWithNoBooks());
    }
}
