package com.polarbookshop.catalogservice.demo;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by I'm_joongyeon on 5/22/24.
 */
@Component
@Profile("testdata") //testdata프로파일이 활성화될때만 로드된다.
public class BookDataLoader {
    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class) //ApplicationReadyEvent가 발생하면 테스트 데이터 생성이 시작된다. 이 이벤트는 애플리케이션 시작 단계가 완료되면 발생한다.
    public void loadBookTestData() {
        bookRepository.deleteAll();
        Book book1 = Book.of("1234567891", "Northen Lights", "Lyra", 9.90);
        Book book2 = Book.of("1234567892", "Polar Journey", "Iorek Polarson", 12.90);

        bookRepository.saveAll(List.of(book1, book2));
    }
}
