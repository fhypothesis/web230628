package com.example.kb3.controller;

import com.example.kb3.dto.FreeBoardDto;
import com.example.kb3.survice.FreeBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/FreeBoard")
public class FreeBoardController {

    @Autowired
    FreeBoardService freeBoardService;

    @GetMapping("")
    public String index(Model model) {

        List<FreeBoardDto> list = freeBoardService.list();
        System.out.println(list);
        model.addAttribute("list", list);
        return "freeboard/index";
    }
}
