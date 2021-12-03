package com.akshitbaunthiyal.library.service;

import com.akshitbaunthiyal.library.entity.Library;
import com.akshitbaunthiyal.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryCreateServiceImpl implements LibraryCreateService {
    @Autowired
    LibraryRepository createRepository;

    public String addSingleLibrary(Library library) {
        createRepository.save(library);
        createRepository.flush();
        return "Library saved";
    }
}