package com.akshitbaunthiyal.library.controller;

import com.akshitbaunthiyal.library.entity.Library;
import com.akshitbaunthiyal.library.service.LibraryReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/read")

public class LibraryReadController {

    @Autowired
    LibraryReadService libraryReadService;

    @GetMapping("/libraries")
    public List<Library> getAllLibraries() {
        return libraryReadService.getAllLibrary();
    }

    @GetMapping("/library/")
    public Optional<Library> getLibraryById(Long id, String name) {
        if (id != null && name == null) {
            return libraryReadService.getLibraryByID(id);
        } else if (name != null && id == null) {
            return libraryReadService.getLibraryByName(name);
        } else if (id != null && name != null) {
            Optional<Library> libraryById = libraryReadService.getLibraryByID(id);
            if (libraryById.isPresent()) {
                if (libraryById.get().getName() == libraryReadService.getLibraryByName(name).get().getName()) {
                    return libraryById;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
