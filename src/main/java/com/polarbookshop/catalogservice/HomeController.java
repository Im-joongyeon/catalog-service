package com.polarbookshop.catalogservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by I'm_joongyeon on 5/16/24.
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public String getGreeting() {
        return "도서 카탈로그에 오신 것을 환영합니다!";
    }
}
