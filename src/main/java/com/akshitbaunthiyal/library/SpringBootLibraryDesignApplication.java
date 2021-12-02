package com.akshitbaunthiyal.library;

import com.akshitbaunthiyal.library.entity.Library;
import com.akshitbaunthiyal.library.service.LibraryReadServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
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
//        readServiceImplMethodsExecution();
    }

    private void readServiceImplMethodsExecution() {
        log.info("--------------------");
        log.info("Fetch all libraries -> {}", libraryReadService.getAllLibrary());
        log.info("--------------------");

        log.info("--------------------");
        log.info("Fetch all libraries with no books -> {}", libraryReadService.getAllLibrariesWithNoBooks());
        log.info("--------------------");

        log.info("--------------------");
        log.info("Fetch page of the library -> {}", libraryReadService.getLibrariesPaged(2, 2).get().collect(Collectors.toList()));
        log.info("--------------------");

        log.info("--------------------");
        log.info("Fetch inserted records in set order -> {}", libraryReadService.getInsertWithIdInOrder());
        log.info("--------------------");

        log.info("--------------------");
        log.info("Fetch libraries fetched, sorted and given books -> {}", libraryReadService.getLibrariesPagedAndSortedByNameAndWithTheseBooks("").get().collect(Collectors.toList()));
        log.info("--------------------");

        log.info("--------------------");
        List<Long> ids = new ArrayList<Long>();
        ids.add(1l);
        ids.add(2l);
        log.info("Fetch libraries by given IDs -> {}", libraryReadService.getLibrariesById(ids));
        log.info("--------------------");

        log.info("--------------------");
        Optional<Library> optionalLibrary = libraryReadService.getLibraryByID(1l);
        if (optionalLibrary.isPresent()) {
            log.info("Fetch library by ID if exists -> {}", optionalLibrary);
        } else {
            log.info("Given ID does not exist in database");
        }
        log.info("--------------------");

        log.info("--------------------");
        optionalLibrary = libraryReadService.getLibraryWithTheseBooks("Momma Ka purse, Doodh Ki Vyatha: Chai banoon ya bachde ki khurakh, Teen Pair Vaala Kutta");
        if(optionalLibrary.isPresent()) {
            log.info("Fetch library with given books -> {}", optionalLibrary);
        }
        else {
            log.info("Library with given book(s) does not exist");
        }
        log.info("--------------------");
    }
}