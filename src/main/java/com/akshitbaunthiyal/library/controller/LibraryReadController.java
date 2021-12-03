package com.akshitbaunthiyal.library.controller;

import com.akshitbaunthiyal.library.entity.Library;
import com.akshitbaunthiyal.library.service.LibraryReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/read")

public class LibraryReadController {

    @Autowired
    LibraryReadService libraryReadService;

    @GetMapping("/libraries")
    public List<Library> getAllLibraries() {
        return libraryReadService.getAllLibrary();
    }

}
