package com.akshitbaunthiyal.library.controller;

import com.akshitbaunthiyal.library.service.LibraryDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delete")

public class LibraryDeleteController {

    @Autowired
    LibraryDeleteService libraryDeleteService;

    @DeleteMapping("/library")
    public void deleteLibraryById(Long id) {
        libraryDeleteService.deleteById(id);
    }
}
