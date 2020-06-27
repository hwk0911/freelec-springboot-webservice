package com.tistory.cafecoder.springboot.config.auth.dto;

import com.tistory.cafecoder.springboot.domain.user.User;
import lombok.Getter;

@Getter
public class SessionUser {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}

/*
SessionUser에는 인증된 사용자 정보만 필요하다.
그외에 정보들은 필요 없으니, name, email, picture만 필드로 선언한다.

 */