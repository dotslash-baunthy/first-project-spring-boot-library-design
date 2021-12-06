package com.akshitbaunthiyal.library.controller;

import com.akshitbaunthiyal.library.entity.Library;
import com.akshitbaunthiyal.library.service.LibraryReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public Optional<Object> getLibrary(Long id, String name) {
        if (id != null && name == null) {
            return Optional.ofNullable(libraryReadService.getLibraryByID(id));
        } else if (id == null && name != null) {
            return Optional.ofNullable(libraryReadService.getLibraryByName(name));
        } else if (id != null && name != null) {
            Optional<Library> libraryById = libraryReadService.getLibraryByID(id);
            Optional<Library> libraryByName = libraryReadService.getLibraryByName(name);
//            Check if libraries fetched via ID and name are present
            if (libraryById.isPresent() && libraryByName.isPresent()) {
//                Check if libraries fetched via ID and name match
                if (libraryById.get().getName() == libraryReadService.getLibraryByName(name).get().getName()) {
                    return Optional.of(libraryById);
                }
//                If libraries by ID and name don't match
                else {
                    return Optional.of("Not found");
                }
            }
//            If libraries by ID and name are not present
            else {
                return Optional.of("Not found");
            }
        }
//        If both ID and name are null
        else {
            return Optional.of("Not found");
        }
    }

}
