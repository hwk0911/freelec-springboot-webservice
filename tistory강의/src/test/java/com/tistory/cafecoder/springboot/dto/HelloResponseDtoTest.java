package com.tistory.cafecoder.springboot.dto;

import com.tistory.cafecoder.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); // 1, 2
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}

/*
1 : assertThat
    assertj라는 테스트 검증 라이브러리의 검증 메소드다.
    검증하고 싶은 대상을 메소드 인자로 받는다.
    메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어사 사용할 수 있다.

2 : isEqaulTo
    asertj의 동등 비교 메소드다.
    assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공이다.


+ junit과 비교하여 assertj의 장점
    1. CoreMatchers와 달리 추가적으로 라이브러리가 필요하지 않다.
        Junit의 assertThat을 쓰게 되면 is()와 같이 CoreMatchers 라이브러리가 필요하다.

    2. 자동완성이 좀 더 확실하게 지원된다.
        IDE에서는 CoreMatchers와 같은 Matcher 라이브러리의 자동완성 지원이 약하다.

    후에 백기선님의 유튜브 'assertJ가 Junit의 assertThat보다 편리한 이유를 참고하자.


+2 책의 내용 도입부에 gradle의 버전을 4로 맞춰야 했는데, 못 보고 디폴드 값인 5버전을 사용하여 에러가 발생했다.
    해결 방법 :
    최상위 디렉토리 > gradle > wrapper > gradle-wrapper.properties 이동
    Alt + F12 (윈도우, 맥 동일) 입력으로 터미널 열기
    터미널에 gradlew wrapper --gradle-version 4.10.2 입력 후 엔터
    gadle-wrapper.properties 확인하면 버전이 4.10.2로 변경된 것을 알 수 있다.
 */