package com.polarbookshop.catalogservice.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * Created by I'm_joongyeon on 5/21/24.
 */

class BookValidationTests {
    private static Validator validator;

    @BeforeAll //테스트 실행전 가장 먼저 실행할 코드 블록
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void whenAllFieldsCorrectThenValidationSucceeds() {
        var book =
                new Book("1234567890", "Title", "Author", 9.90);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        Assertions.assertThat(violations).isEmpty(); //유효성 검사에서 오류가 없음을 확인한다.
    }

    @Test
    void whenIsbnDefinedButIncorrectThenValidationFails() {
        Book book = new Book("a234567890", "Title", "Author", 9.90);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        Assertions.assertThat(violations).hasSize(1);
        Assertions.assertThat(violations.iterator().next().getMessage())
                .isEqualTo("The ISBN format must be valid.");
    }
}
