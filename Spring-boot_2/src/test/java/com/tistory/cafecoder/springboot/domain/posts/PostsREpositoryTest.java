package com.tistory.cafecoder.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsREpositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp () {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기 () {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        String author = "hwk0911@gmail.com";

        postsRepository.save(Posts.builder()
            .title(title)
            .content(content)
            .author(author)
            .build()
        );

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        assertThat(posts.getAuthor()).isEqualTo(author);
    }
}

/*
@After
Junit에서 단위 테스트가 끝날 때 마다 수행되는 메소드를 지정한다.
보통은 배포 전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기 위해 사용한다.
여러 테스트가 동시에 수행되면 테스트용 데이터베이스인 H2에 데이터가 그대로 남아있어 다음 테스트 실행 시 테스트가 실패할 수 있다.

postsRepository.save
테이블 posts에 insert/update 쿼리를 실행한다.
id값이 있다면 update가, 없다면 insert쿼리가 실행된다.

postsRepository.findAll()
테이블 posts에 있는 모든 데이터를 조회해오는 메소드다.

별다른 설정 없이 @SpringBootTest를 사용할 경우 H2데이터베이스를 자동으로 실행해 준다.
 */