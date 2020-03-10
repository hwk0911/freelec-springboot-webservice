package com.tistory.cafecoder.springboot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}

/*
보통 ibatis나 MyBatis 등에서 Dao라고 불리는 DB Layer 접근자다.
JPA에선 Repository라 부르며, Interface로 생성한다.
단순히 인터페이스 생성 후 JpaRepository<Entity 클래스, PK 타입>를 상속하면 기본적인 CRUD 메소드가 자동 생성됨.

@Repository를 추가할 필요가 없다.

주의 : Entity클래스와 기본 Entity Repository는 함꼐 위치해야 한다.
둘은 아주 밀접한 관계고, Entity 클래스는 기본 Repository 없이는 제대로 역할을 할 수 없다.

후에 프로젝트 규모가 커져 도메인별로 프로젝트를 분리해야 한다면,
이 때 Entity 클래스와, 기본 Repository 는 함께 움직여야 하므로,
도메인 패키지에서 함께 관리한다.

CRUD 메소드 : 기본적인 데이터 처리 기능을 묶어 일컫는 말
    1 : Create - 생성
    2 : Read - 읽기(또는 인출)
    3 : Update - 갱신
    4 : Delete - 삭제(또는 파괴)

사용자 인터페이스가 갖추어야 할 기능(정보의 참조/검색/갱신)을 가리키는 용어로서도 사용된다.
 */