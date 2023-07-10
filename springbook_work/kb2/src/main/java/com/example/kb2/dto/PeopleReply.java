package com.example.kb2.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PeopleReply {
    private int idx_people;
    private int ref_idx_reply;
    private int ref_level;
    private String content;
    private String path;

}