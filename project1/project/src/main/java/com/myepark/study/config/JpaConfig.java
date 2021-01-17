package com.myepark.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing  // JPA에 대해 활성화 시키겠다.
public class JpaConfig {

}
