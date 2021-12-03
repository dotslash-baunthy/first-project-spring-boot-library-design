package com.akshitbaunthiyal.library.service;

import com.akshitbaunthiyal.library.entity.Library;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface LibraryReadService {
    List<Library> getAllLibrary();

    List<Library> getAllLibrariesWithNoBooks();

    Page<Library> getLibrariesPaged(int pageNumber, int pageSize);

    List<Library> getInsertWithIdInOrder();

    Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBookNames);

    List<Library> getLibrariesById(List<Long> ids);

    Optional<Library> getLibraryByID(Long id);

    Optional getLibraryWithTheseBooks(String commaSeparatedBookNames);

    Optional<Library> getLibraryByName(String name);
}
