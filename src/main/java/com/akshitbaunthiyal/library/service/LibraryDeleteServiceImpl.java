package com.akshitbaunthiyal.library.service;

import com.akshitbaunthiyal.library.entity.Library;
import com.akshitbaunthiyal.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryDeleteServiceImpl implements LibraryDeleteService {

    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public String deleteById(Long id) {
        libraryRepository.deleteById(id);
        return "Library with ID " + id + " has been deleted";
    }

    @Override
    public String deleteAll() {
        libraryRepository.deleteAll();
        return "Prune complete";
    }

    @Override
    public String deleteAllById(List<Long> libraries) {
        libraryRepository.deleteAllById(libraries);
        return "Libraries deleted";
    }
}
