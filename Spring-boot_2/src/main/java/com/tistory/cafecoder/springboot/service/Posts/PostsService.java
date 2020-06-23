package com.tistory.cafecoder.springboot.service.Posts;

import com.tistory.cafecoder.springboot.domain.posts.PostsRepository;
import com.tistory.cafecoder.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}

/*
Autowired가 없는 이유

스프링에선 Bean을 주입받는 방식이 다음과 같다.
1. @Autowired
2. setter
3. 생성자

이 중 가장 권장하는 방식이 생성자로 주입받는 방식이다. (@Autowired는 권장하지 않는다.)
즉 생성자로 Bean 객체를 받도록 하면 @Autowired와 같은 효과를 볼 수 있다.

위 코드에서 생성자는 @RequiredArgsConstructor가 대신 생성해준다.
 */