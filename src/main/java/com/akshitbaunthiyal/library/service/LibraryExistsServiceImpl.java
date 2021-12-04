package com.akshitbaunthiyal.library.service;

import com.akshitbaunthiyal.library.entity.Library;
import com.akshitbaunthiyal.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class LibraryExistsServiceImpl implements LibraryExistsService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public boolean checkLibraryExistsById(Long id) {
        return libraryRepository.existsById(id);
    }

    @Override
    public boolean checkIfLibraryExistsByExample(String name) {
        Library library = new Library();
        library.setName(name);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("name",ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","commaSeparatedBookName");
        Example<Library> example = Example.of(library,exampleMatcher);
        return libraryRepository.exists(example);
    }
}
