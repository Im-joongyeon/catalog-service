package com.polarbookshop.catalogservice.domain;

/**
 * Created by I'm_joongyeon on 5/20/24.
 */
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String isbn) {
        super("The book with ISBn " + isbn + " was not found.");
    }
}
