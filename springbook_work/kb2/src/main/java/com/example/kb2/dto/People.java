package com.example.kb2.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
// @Data 로 해도 됨
@Builder
public class People {
    private int idx;
    private String name;
    private int age;
}

