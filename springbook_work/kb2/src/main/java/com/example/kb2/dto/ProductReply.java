package com.example.kb2.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductReply {
    private int idp_reply;
    private int idp_product;
    private int ref_idp_reply;
    private int ref_level;
    private String content;
    private String path;

}