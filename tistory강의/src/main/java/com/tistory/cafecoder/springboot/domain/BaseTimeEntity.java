package com.tistory.cafecoder.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 1
@EntityListeners(AuditingEntityListener.class) // 2
public class BaseTimeEntity {

    @CreatedDate // 3
    private LocalDateTime createdDate;

    @LastModifiedDate // 4
    private LocalDateTime modifiedDate;
}

/*
1 : @MappedSuperclass
    JPA Enitity 클래스들이 BaseTimeEntity를 상속할 경우
    필드들(createdDate, modifiedDate)도 칼럼으로 인식하도록 한다.

2 : @EntityListenrs(AuditingEntityListener.class)
    BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.

    + AAuditing기능
        의심가는 데이터베이스의 작업을 모니터링 하고, 기록 정보를 수집 하는 기능

3 : @CreatedDate
    Entity가 생성되어 저장될 때 시간이 자동 저장 된다.

4 : @LastModifiedDate
    조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.
 */