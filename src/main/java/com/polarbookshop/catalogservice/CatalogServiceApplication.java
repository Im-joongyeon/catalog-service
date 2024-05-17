package com.polarbookshop.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/** @SpringBootApplication
 *  아래의 3 가지 다른 어노테이션을 포함한다.
 * 1. @Configuration: 해당 클래스가 빈을 정의하는 클래스라는 것을 나타냄
 * 2. @ComponentScan: 컴포넌트 검색을 통해 빈을 찾아 스프링 컨텍스트에 자동으로 등록
 * 3. @EnableAutoConfiguration: 스프링 부트에서 제공하는 자동 설정 기능을 활성화
 */
public class CatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class, args);
    }

}
