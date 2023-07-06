package com.example.kb2.dto;


import ch.qos.logback.classic.spi.LoggingEventVO;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {

    private int idx;
    private String content;


}
