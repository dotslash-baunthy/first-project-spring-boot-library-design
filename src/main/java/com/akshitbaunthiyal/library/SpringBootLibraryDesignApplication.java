package com.akshitbaunthiyal.library;

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
    }
}
