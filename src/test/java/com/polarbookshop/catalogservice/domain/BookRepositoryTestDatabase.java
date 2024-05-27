package com.polarbookshop.catalogservice.domain;

import com.polarbookshop.catalogservice.config.DataConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by I'm_joongyeon on 5/24/24.
 */
@DataJdbcTest //스프링 데이터 JDBC 컴포넌트를 집중적으로 테스트하는 클래스임을 나타낸다.
@Import(DataConfig.class) //데이터 설정을 임포트한다(감사를 활성화하기 위해 필요
@AutoConfigureTestDatabase( //테스트컨테이너를 이용해야 하기 때문에 내장 테스트 데이터베이스 사용을 비활성화
        replace = AutoConfigureTestDatabase.Replace.NONE
)
@ActiveProfiles("integration")
class BookRepositoryTestDatabase {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private JdbcAggregateTemplate jdbcAggregateTemplate;

    @Test
    void findBookByIsbnWhenExisting() {
        var bookIsbn = "1234567";
        Book book = Book.of(bookIsbn, "Title", "Author", 12.90, "Polarsophia");
        jdbcAggregateTemplate.insert(book);
        Optional<Book> actualBook = bookRepository.findByIsbn(bookIsbn);

        assertThat(actualBook).isPresent();
        assertThat(actualBook.get().isbn()).isEqualTo(book.isbn());

    }
}
