package com.akshitbaunthiyal.library;

import com.akshitbaunthiyal.library.entity.Library;
import com.akshitbaunthiyal.library.model.Course;
import com.akshitbaunthiyal.library.model.FullName;
import com.akshitbaunthiyal.library.service.LibraryReadServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

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
        log.info("Fetch page of the library -> {}" + libraryReadService.getLibrariesPaged(2, 2).get().collect(Collectors.toList()));
        log.info("Fetch inserted records in set order -> {}" + libraryReadService.getInsertWithIdInOrder(Sort.Direction.DESC));
        log.info("--------------------");
        log.info("Fetch libraries fetched, sorted and given books -> {}" + libraryReadService.getLibrariesPagedAndSortedByNameAndWithTheseBooks("").get().collect(Collectors.toList()));
    }
}