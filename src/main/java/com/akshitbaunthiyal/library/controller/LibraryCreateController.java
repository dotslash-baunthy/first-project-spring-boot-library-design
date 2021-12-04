package com.akshitbaunthiyal.library.controller;

import com.akshitbaunthiyal.library.entity.Library;
import com.akshitbaunthiyal.library.service.LibraryCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/create")
public class LibraryCreateController {

    @Autowired
    LibraryCreateService libraryCreateService;

    @PostMapping("/library")
    public String addLibrary(Library library) {
        return libraryCreateService.addLibrary(library);
    }

    @PostMapping("/libraries")
    public String addLibraries(@RequestBody List<Library> libraries) {
        return libraryCreateService.addLibraries(libraries);
    }

}
