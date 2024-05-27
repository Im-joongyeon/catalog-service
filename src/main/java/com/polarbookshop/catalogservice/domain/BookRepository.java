package com.polarbookshop.catalogservice.domain;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by I'm_joongyeon on 5/20/24.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
    Iterable<Book> findAll();
    Optional<Book> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
    Book save(Book book);
    @Modifying //데이터베이스 상태를 수정할 연산임을 나타낸다.
    @Transactional
    @Query("delete from Book where isbn = :isbn")
    void deleteByIsbn(String isbn);
}
