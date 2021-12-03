package com.akshitbaunthiyal.library.controller;

import com.akshitbaunthiyal.library.service.LibraryExistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exist")
public class LibraryExistsController {

    @Autowired
    LibraryExistsService libraryExistsService;

    @GetMapping("/byId/")
    public boolean existsLibrary(Long id) {
        return libraryExistsService.checkLibraryExistsById(id);
    }

    @GetMapping("/byName")
    public boolean existLibrary(String name) {
        return libraryExistsService.checkIfLibraryExistsByExample(name);
    }

}
