package com.tistory.cafecoder.springboot;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 6
@NoArgsConstructor // 5
@Entity // 1
public class Posts {

    @Id // 2
    @GeneratedValue( strategy = GenerationType.IDENTITY) // 3
    private Long Id;

    @Column( length = 500, nullable = false) // 4
    private String title;

    @Column( columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 7
    public Posts(String title, String content, String author ) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

/*
Posts 클래스는 실제 DB의 테이블과 매칭될 클래스다.
이것을 Entity클래스 라고도 한다.

JPA를 사용하면, DB 데이터에 작업할 경우 실제 쿼리를 날리기보다는,
이 Entity 클래스의 수정을 통해 작업한다.

<Posts클래스에 사용 된 JPA제공 어노테이션>
1 : @Entity
    테이블과 링크될 클래스임을 명시한다.
    기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭한다.
    카멜케이스 : 쌍봉낙타의 등 모양의 네이밍 (ex : CamelExampleNaming)
    언더스코어 : ('_')의 사용을 통한 네이밍 (ex : under_score_naming/0

2 : @Id
    해당 테이블의 PK 필드를 나타낸다.
    PK 필드 : 테이블의 레코드를 구분할 수 있는 최소의 컬럼
   +FK 필드 : PK필드의 자식 개념

3 : @GeneratedValue
    PK의 생성 규칙을 나타낸다.
    스프링 부트 2.0 에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto increment가 된다.
    스프링 부트 2.0 버전과 1.5 버전의 차이는 https://jojoldu.tistory.com/295 를 참조

4 : @Column
    테이블의 칼럼을 나타낸다. 선언하지 않아도 해당 클래스의 필드는 모두 칼럼이 된다.
    사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.
    문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나,
    (ex : title), 타입을 TEXT로 변경하고 싶거나(ex : content) 등의 경우에 사용된다.

<lombok 라이브러리 어노테이션>
5 : @NoArgsConstructor
    기본 생성자 자동 추가
    public Posts() {}와 같은 효과

6 : @Getter
    클래스 내 모든 필드의 Getter 메소드를 자동생성

7 : @Builder
    해당 클래스의 빌더 패턴 클래스를 생성
    생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
 */
