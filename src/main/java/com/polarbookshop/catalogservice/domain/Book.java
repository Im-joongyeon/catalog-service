package com.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.Instant;


/**
 * Created by I'm_joongyeon on 5/20/24.
 */
//record: 자바 14에서 도입된 불가변 데이터를 좀 더 편하게 표현하기 위해 몇 가지 제약을 가지고 있는 클래스
public record Book(
        @Id
        Long id,

        @NotBlank(message = "The book ISBN must be defined")
        @Pattern(
                regexp = "^([0-9]{10}|[0-9]{13})$",
                message = "The ISBN format must be valid."
        )
        String isbn,
        @NotBlank(message = "The book title must be defined.") //널 값이 되어서는 안되고, 화이트스페이스가 아닌 문자를 최소 하나 이상 가져야한다.
        String title,
        @NotBlank(message = "The book author must be defined.")
        String author,
        @NotNull(message = "The book price must be defined.")
        @Positive(message = "The book price must be greater than zero") // 널 값이 되어서는 안되고, 0보다 큰 수이어야 한다.
        Double price,


        @CreatedDate //엔티티가 생성된 때
        Instant createdDate,

        @LastModifiedDate
        Instant lastModifiedDate,
        @Version
        int version

) {
        public static Book of(
                String isbn, String title, String author, Double price
        ) {
                return new Book(
                        //id 가 null이고 버전이 0이면 새로운 엔티티로 인식)
                        null, isbn, title, author, price, null, null, 0
                );
        }
}
