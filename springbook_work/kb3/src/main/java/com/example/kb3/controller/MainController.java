package com.example.kb3.controller;


import com.example.kb3.entity.FreeBoard;
import com.example.kb3.repository.FreeBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    FreeBoardRepository freeBoardRepository;

    @GetMapping("/")
    public String index() {
        FreeBoard f1 = new FreeBoard().builder()
                .name("홍길동")
                .content("내용")
                .build();

        freeBoardRepository.save(f1);
        List<FreeBoard> list = freeBoardRepository.findAll();
        System.out.println(list);
        return "index";
    }
}
