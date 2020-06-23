package com.tistory.cafecoder.springboot.web.dto;

import com.tistory.cafecoder.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.content = entity.getContent();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
    }
}
/*
PostsResponseDto는 Entity의 필드 중 일부만을 사용한다.
따라서 Entity를 받아 필드에 값을 넣는다. 굳이 모든 필드를 가진 생성자가 필요하진 않으므로 Dto는 Entity를 받아 처리한다.

 */