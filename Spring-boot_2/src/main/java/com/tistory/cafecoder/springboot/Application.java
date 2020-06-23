package com.tistory.cafecoder.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //내장 WAS(Web Application Server)를 실행한다.
        SpringApplication.run(Application.class, args);
    }
}

/*
SpringApplication.run(Application.class, args);
를 선언하면, 항상 서버에 톰캣을 설치할 필요가 없게되며, Jar파일로 실행하면 된다.

@EnableJpaAuditing
JPA Auditing 활성화
 */