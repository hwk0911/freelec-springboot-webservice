package com.tistory.cafecoder.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT P FROM POSTS P ORDER BY P.ID DESC")
    List<Posts> findAllDesc();
}
/*
iBatis or Mybatis등에서 Dao라 불리는 DB Layer 접근자다.
JPA에선 REpository라고 부르며, 인터페이스로 생성한다.
단순히 인터페이스를 생성 후, JpaRepository<Entity 클래스, PK타입>을 상속하면 기볹거인 CRUD 메소드가 자동으로 생성된다.

CRUD
C : Create
R : Read
U : Update
D : Delete

@Repository를 추가할 필요도 없다.

주의할 점은, Entity클래스와 기본 Entity Repository는 함께 위치해야 하는 점이다.
둘은 아주 밀접한 관계며, Entity클래스는 기본 Repository 없이는 제대로 역할을 수행할 수 없다.

후에 프로젝트 규모가 커져 도메인별로 프로젝트를 분리해야 한다면, 이 때 Entity 클래스와 Repository는 함께 움직여야 하므로,
도메인 패키지에서 함께 관리한다.
 */