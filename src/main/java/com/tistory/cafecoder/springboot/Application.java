package com.tistory.cafecoder.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //내장 WAS(Web Application Server, 웹 애플리케이션 서버)를 실행한다.
        //서버에 톰캣을 설치할 필요가 없게 된다. (jar파일로 실행하면 된다.)
        SpringApplication.run(Application.class, args);
    }
}

/*
SpringBootApplication Annotationc이 있는 위치부터 읽기 시작한다.
따라서 항상 최상단에 위치해야 한다.

Spring Boot에서는 내장 WAS를 사용하는 것을 권장한다.
이유는 언제 어디서나 같은 환경에서 스프링 부트를 배포 할 수 있기 때문이다.
외장WAS를 사용하면, 모든 서버는 WAS의 종류와 버전, 설정을 일치시켜야 한다.

내장 WAS를 사용해서 오는 성능상의 이슈는 크게 고려하지 않아도 된다.
 */