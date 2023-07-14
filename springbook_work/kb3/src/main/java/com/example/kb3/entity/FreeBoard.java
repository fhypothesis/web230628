package com.example.kb3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FreeBoard extends BaseTimeEntity {

//    데이터베이스 테이블에 속성 추가하기(application.properties에 설정하면 자동으로 테이블 생성하고 속성추가함)
//    같은 이름의 테이블이 있으면 drop함
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idx;
    private String name;
    private String title;
    private String content;

}
