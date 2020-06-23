package com.tistory.cafecoder.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

/*
실제 DB와 연결 될 클래스다.

@Entity
테이블과 링크될 클래스임을 나타낸다.
기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭한다. (productName -> product_name)

@Id
해당 테이블의 PK필드를 나타낸다.

@GeneratedValue
PK의 생성 규칙을 나타낸다.
스프링부트 2.0 에서는 GeneratedType.IDENTITY 옵션을 추가해야 auto_increment가 된다.

스프링부트 2.0과 1.5의 차이 참고 : https://jojoldu.tistory.com/295

@Column
테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.
문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나, 타입을 TEXT로 변경하고 싶은 경우 등 사용된다.
 */