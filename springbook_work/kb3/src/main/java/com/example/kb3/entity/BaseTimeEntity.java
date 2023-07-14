package com.example.kb3.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 여기에 있는 속성이 자식클래스에 들어감
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate // 생성일 속성 자동으로 생성
    private LocalDateTime createDate;

    @LastModifiedDate //마지막 수정일 속성 자동으로 생성
    private LocalDateTime lastModifiedDate;

}
