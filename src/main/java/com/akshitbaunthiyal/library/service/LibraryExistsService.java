package com.akshitbaunthiyal.library.service;

public interface LibraryExistsService {
    boolean checkLibraryExistsById(Long id);

    boolean checkIfLibraryExistsByExample(String name);
}
