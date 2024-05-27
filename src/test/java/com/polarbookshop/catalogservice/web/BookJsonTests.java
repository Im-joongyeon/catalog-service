package com.polarbookshop.catalogservice.web;
import com.polarbookshop.catalogservice.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by I'm_joongyeon on 5/21/24.
 */
@JsonTest //json직렬화에 중점을 둔 테스트 클래스
public class BookJsonTests {
    @Autowired
    private JacksonTester<Book> json; //json 직렬화 및 역직렬화를 확인하기 위한 유틸리티 클래스
/*
    @Test
    void testSerialize() throws Exception {
        Book book = new Book("1234567890", "Title", "Author", 9.90);
        JsonContent<Book> jsonContent = json.write(book);
        assertThat(jsonContent).extractingJsonPathStringValue("@.isbn")
                .isEqualTo(book.isbn());
        assertThat(jsonContent).extractingJsonPathStringValue("@.title")
                .isEqualTo(book.title());
        assertThat(jsonContent).extractingJsonPathStringValue("@.author")
                .isEqualTo(book.author());
        assertThat(jsonContent).extractingJsonPathNumberValue("@.price")
                .isEqualTo(book.price());
    }
    @Test
    void testDeserialize() throws Exception {
        //자바 텍스트 블록 기능을 사용해서 json객체를 정의
        var content = """ 
                {
                    "isbn" : "1234567890",
                    "title" : "Title",
                    "author" : "Author",
                    "price" : 9.90
                }
                """;
        //json객체를 자바 객체로 변환 확인
        assertThat(json.parse(content))
                .usingRecursiveComparison()
                .isEqualTo(new Book("1234567890", "Title", "Author", 9.90));
    }

 */
}
