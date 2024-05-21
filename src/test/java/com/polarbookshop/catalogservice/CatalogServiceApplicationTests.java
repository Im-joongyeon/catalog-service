package com.polarbookshop.catalogservice;

import com.polarbookshop.catalogservice.domain.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
/** @SpringBootTest
 * 스프링 부트 애플리케이션을 테스트하기 위한 셋업 제공
 */
class CatalogServiceApplicationTests {
    @Autowired
    private WebTestClient webTestClient;
    @Test
    void whenPortRequestThenBookCreated() {
        Book book = new Book("1231231231", "Title", "Author", 9.90);

        webTestClient
                //http요청을 보낸다
                .post()
                .uri("/books")
                .bodyValue(book)
                //요청 전송
                .exchange()
                .expectBody(Book.class).value(actualBook -> {
                    Assertions.assertThat(actualBook).isNotNull(); //HTTP 응답의 본문이 널 값이 아닌지 확인
                    Assertions.assertThat(actualBook.isbn()).isEqualTo(book.isbn()); //생성된 객체가 예상과 동일한지 확인
                });
    }
}
