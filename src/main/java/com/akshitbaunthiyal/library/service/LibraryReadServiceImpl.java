package com.akshitbaunthiyal.library.service;

import com.akshitbaunthiyal.library.entity.Library;
import com.akshitbaunthiyal.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryReadServiceImpl {
    @Autowired
    LibraryRepository readRepository;

    public List<Library> getAllLibrary() {
        return readRepository.findAll();
    }

    //    public List<Library> getAllLibrariesWithNoBooks() {
    public List<Library> getAllLibrariesWithNoBooks() {
        Library libraryWithNoBooks = new Library();
        libraryWithNoBooks.setCommaSeparatedBookNames("");
        ExampleMatcher considerOnlyCommaSeparatedBookNames = ExampleMatcher.matching()
                .withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id", "name");
        Example<Library> libraryExample = Example.of(libraryWithNoBooks, considerOnlyCommaSeparatedBookNames);
        return readRepository.findAll(libraryExample);
    }
}
