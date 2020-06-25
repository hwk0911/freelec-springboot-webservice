package com.tistory.cafecoder.springboot.service.Posts;

import com.tistory.cafecoder.springboot.domain.posts.Posts;
import com.tistory.cafecoder.springboot.domain.posts.PostsRepository;
import com.tistory.cafecoder.springboot.web.dto.PostsListResponseDto;
import com.tistory.cafecoder.springboot.web.dto.PostsResponseDto;
import com.tistory.cafecoder.springboot.web.dto.PostsSaveRequestDto;
import com.tistory.cafecoder.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
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


update기능에서 데이터베이스에 쿼리를 날리는 부분이 없다.
이게 가능한 이유는 JPA의 영속성 컨텍스트 때문이다.

영속성 컨텍스트란, 엔티티를 영구 저장하는 환경이다.
일종의 논리적 개념이라 보면 되며, JPA의 핵심 내용은 엔티티가 영속성 컨텍스트에 포함되어 있냐 아니냐로 갈린다.

JPA의 엔티티 매니저가 활성화된 상태로 (Spring Data Jpa를 사용하면 기본 옵션이다.)
트랜잭션 안에서 데이터베이스의 데이터를 가져오면 이 데이터는 영속성 컨텍스트가 유지된 상태다.

이 상태에서 해당 데이터의 값을 변경하면 트랜잭션이 끝나는 시점에 해당 테이블에 변경분을 반영한다.
즉, Entity 객체의 값만 변경하면 별도로 Update 쿼리를 날릴 필요가 없다는 것이다.
이 개념을 더티 체킹(Dirty Checking)이라 한다.

.map(PostsListResponseDto::new) = .map(posts -> new PostsListResponseDto(posts))
postsRepository 결과로 넘어온 Posts의 Stream을 map을 통해 PostsListResponseDto 변환 -> List로 반환하는 메소드다.

@Transactional(readOnly = true)
readOnly를 인자로 추가하면, 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선된다.
때문에, 등록, 수정, 삭제 기능이 전혀 없는 서비스 메소드에 사용하는 것을 추천한다.
 */