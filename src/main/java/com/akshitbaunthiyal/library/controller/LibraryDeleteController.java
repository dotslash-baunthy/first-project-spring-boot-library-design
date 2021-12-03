package com.akshitbaunthiyal.library.controller;

import com.akshitbaunthiyal.library.service.LibraryDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delete")

public class LibraryDeleteController {

    @Autowired
    LibraryDeleteService libraryDeleteService;

    @DeleteMapping("/library")
    public void deleteLibraryById(Long id) {
        libraryDeleteService.deleteById(id);
    }

    @PostMapping("/libraries")
    public void deleteAllById(@RequestBody List<Long> libraries) {
        libraryDeleteService.deleteAllById(libraries);
    }
}
