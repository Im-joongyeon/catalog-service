package com.polarbookshop.catalogservice.domain;

import java.util.Optional;

/**
 * Created by I'm_joongyeon on 5/20/24.
 */
public interface BookRepository {
    Iterable<Book> findAll();

    Optional<Book> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
    Book save(Book book);
    void deleteByIsbn(String isbn);
}
