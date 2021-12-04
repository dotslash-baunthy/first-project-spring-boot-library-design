package com.akshitbaunthiyal.library.service;

import com.akshitbaunthiyal.library.entity.Library;
import com.akshitbaunthiyal.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryCreateServiceImpl implements LibraryCreateService {
    @Autowired
    private LibraryRepository createRepository;

    public String addLibrary(Library library) {
        createRepository.save(library);
        createRepository.flush();
        return "Library saved";
    }

    @Override
    public String addLibraries(List<Library> libraries) {
        createRepository.saveAllAndFlush(libraries);
        return "Libraries saved";
    }
}