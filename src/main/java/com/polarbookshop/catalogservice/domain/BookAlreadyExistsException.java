package com.polarbookshop.catalogservice.domain;

/**
 * Created by I'm_joongyeon on 5/20/24.
 */
public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException(String isbn) {
        super("A Book with ISBN " + isbn + " already exists.");
    }
}
