package com.polarbookshop.catalogservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

/**
 * Created by I'm_joongyeon on 5/24/24.
 */

@Configuration //스프링 설정의 소스임을 나타낸다.
@EnableJdbcAuditing //지속성 엔티티에 대한 감사를 활성화
public class DataConfig {
}
