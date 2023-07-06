package com.example.kb2.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private int idp;
    private String productName;
    private int purchasesNum;

}
