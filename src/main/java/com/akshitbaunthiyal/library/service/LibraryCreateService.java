package com.akshitbaunthiyal.library.service;

import com.akshitbaunthiyal.library.entity.Library;

import java.util.List;

public interface LibraryCreateService {
    String addLibrary(Library library);
    String addLibraries(List<Library> libraries);
}
