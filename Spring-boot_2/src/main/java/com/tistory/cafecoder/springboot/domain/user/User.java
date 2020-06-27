package com.tistory.cafecoder.springboot.domain.user;

import com.tistory.cafecoder.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User (String name, String picture, String email , Role role) {
        this.name = name;
        this.picture = picture;
        this.email = email;
        this.role = role;
    }

    public User update (String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}

/*
@Enumerated(EnumType.STRING)
JPA로 데이터베이스를 저장할 때, Enum값을 어떤 형태로 저장할지를 결정한다.
기본적으로는 int로 된 숫자가 저장된다.
숫자로 저장되면 데이터베이스로 확인할 때 그값이 무슨 코드를 의미하는지를 알 수 없다.
그래서 문자열(EnumType.STRING)로 저장될 수 있도록 선언한다.
 */