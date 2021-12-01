package com.akshitbaunthiyal.library.service;

import com.akshitbaunthiyal.library.entity.Library;
import com.akshitbaunthiyal.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryReadServiceImpl {
    @Autowired
    LibraryRepository readRepository;

    public List<Library> getAllLibrary() {
        return readRepository.findAll();
    }

    public List<Library> getAllLibrariesWithNoBooks() {
        Library libraryWithNoBooks = new Library();
        libraryWithNoBooks.setCommaSeparatedBookNames("");
        ExampleMatcher considerOnlyCommaSeparatedBookNames = ExampleMatcher.matching()
                .withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id", "name");
        Example<Library> exampleLibraryWithNoBook = Example.of(libraryWithNoBooks, considerOnlyCommaSeparatedBookNames);
        return readRepository.findAll(exampleLibraryWithNoBook);
    }

//    Add noEmptyLibrary() function

    public Page<Library> getLibrariesPaged(int pageNumber, int pageSize) {
        Pageable recordsPage = PageRequest.of(pageNumber, pageSize);
        return readRepository.findAll(recordsPage);
    }

    public List<Library> getInsertWithIdInOrder() {
        return readRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBookNames) {
        Library libraryWithGivenBooks = new Library();
        libraryWithGivenBooks.setCommaSeparatedBookNames(commaSeparatedBookNames);
        ExampleMatcher considerOnlyTheseBooks = ExampleMatcher.matching()
                .withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id", "name");
        Example<Library> exampleLibraryWithGivenBook = Example.of(libraryWithGivenBooks, considerOnlyTheseBooks);
        Pageable sortedLibraries = PageRequest.of(0, 2, Sort.by("name"));
        return readRepository.findAll(exampleLibraryWithGivenBook, sortedLibraries);
    }
}
