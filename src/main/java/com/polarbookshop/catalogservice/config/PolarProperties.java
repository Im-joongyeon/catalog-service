package com.polarbookshop.catalogservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by I'm_joongyeon on 5/22/24.
 */
@ConfigurationProperties(prefix = "polar") //@RefreshScopeRefreshedEvent를 기본적으로 포함한다. -> 액츄에이터에서 사용
public class PolarProperties {
    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}

