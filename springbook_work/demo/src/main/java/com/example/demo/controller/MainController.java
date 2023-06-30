package com.example.demo.controller;

import com.example.demo.obj.AA;
import com.example.demo.obj.BB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//문자열 그대로 보내줌
public class MainController {

    @Autowired
    AA aa;

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
