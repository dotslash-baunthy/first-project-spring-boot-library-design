package com.akshitbaunthiyal.library.service;

import com.akshitbaunthiyal.library.entity.Library;

import java.util.List;

public interface LibraryDeleteService {
    String deleteById(Long id);

    String deleteAll();

    String deleteAllById(List<Long> libraries);
}
