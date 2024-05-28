package com.polarbookshop.catalogservice.web;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by I'm_joongyeon on 5/20/24.
 */

@RestController
@RequestMapping("books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Iterable<Book> get() {
        return bookService.viewBookList();
    }

    @GetMapping("{isbn}")
    public Book getByIsbn(@PathVariable String isbn) {
        return bookService.viewBookDetails(isbn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // -> 성공적으로 생성되면 201 상태코드를 반환
                    //@RequestBody는 웹 요청의 본문을 메서드 변수로 바인드한다.
    public Book post(@Valid @RequestBody Book book) {
        return bookService.addBookToCatalog(book);
    }

    @DeleteMapping("{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // -> 성공적으로 삭제되면 204 상태코드 반환
    public void delete(@PathVariable String isbn) {
        bookService.removeBookFromCatalog(isbn);
    }

    @PutMapping("{isbn}")
    public Book put(@PathVariable String isbn,@Valid @RequestBody Book book) {
        return bookService.editBookDetails(isbn, book);
    }
}
