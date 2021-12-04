package com.akshitbaunthiyal.library.service;

import com.akshitbaunthiyal.library.entity.Library;
import com.akshitbaunthiyal.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryReadServiceImpl implements LibraryReadService {
    @Autowired
    private LibraryRepository readRepository;

    @Override
    public List<Library> getAllLibrary() {
        return readRepository.findAll();
    }

    @Override
    public List<Library> getAllLibrariesWithNoBooks() {
        Library libraryWithNoBooks = new Library();
        libraryWithNoBooks.setCommaSeparatedBookNames("");
        ExampleMatcher considerOnlyCommaSeparatedBookNames = ExampleMatcher.matching()
                .withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id", "name");
        Example<Library> exampleLibraryWithNoBook = Example.of(libraryWithNoBooks, considerOnlyCommaSeparatedBookNames);
        return readRepository.findAll(exampleLibraryWithNoBook);
    }

//    Add noEmptyLibrary() function

    @Override
    public Page<Library> getLibrariesPaged(int pageNumber, int pageSize) {
        Pageable recordsPage = PageRequest.of(pageNumber, pageSize);
        return readRepository.findAll(recordsPage);
    }

    @Override
    public List<Library> getInsertWithIdInOrder() {
        return readRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBookNames) {
        Library libraryWithGivenBooks = new Library();
        libraryWithGivenBooks.setCommaSeparatedBookNames(commaSeparatedBookNames);
        ExampleMatcher considerOnlyTheseBooks = ExampleMatcher.matching()
                .withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id", "name");
        Example<Library> exampleLibraryWithGivenBook = Example.of(libraryWithGivenBooks, considerOnlyTheseBooks);
        Pageable sortedLibraries = PageRequest.of(0, 2, Sort.by("name"));
        return readRepository.findAll(exampleLibraryWithGivenBook, sortedLibraries);
    }

    @Override
    public List<Library> getLibrariesById(List<Long> ids) {
        return readRepository.findAllById(ids);
    }

    @Override
    public Optional<Library> getLibraryByID(Long id) {
        return readRepository.findById(id);
    }

    @Override
    public Optional getLibraryWithTheseBooks(String commaSeparatedBookNames) {
        Library library = new Library();
        library.setCommaSeparatedBookNames(commaSeparatedBookNames);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","name");
        Example example = Example.of(library, exampleMatcher);
        return readRepository.findOne(example);
    }

    @Override
    public Optional<Library> getLibraryByName(String name) {
        Library library = new Library();
        library.setName(name);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("name",ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","commaSeparatedBookName");
        Example<Library> example = Example.of(library,exampleMatcher);
        return readRepository.findOne(example);
    }

}
