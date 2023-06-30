package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//HTML 파일 찾아줌(타임리프 라이브러리 넣어줬기 때문에 스프링부트와 html파일이 연결됨)
public class MainHtmlController {

    @GetMapping("aa")
    public String aa(Model model, String num1, String num2) {
        System.out.println("출력");
        System.out.println(num1);
        System.out.println(num2);
        if(num1 == null) num1 = "0";
        if(num2 == null) num2 = "0";
        model.addAttribute("data", "더하기");
        model.addAttribute("result", Integer.parseInt(num1)+Integer.parseInt(num2));
        return "aa";
    }

    @GetMapping("bb")
    public String bb(Model model, String num1, String num2) {
        System.out.println("출력");
        if(num1 == null) num1 = "0";
        if(num2 == null) num2 = "0";
        model.addAttribute("data", "빼기");
        model.addAttribute("result", Integer.parseInt(num1)-Integer.parseInt(num2));
        return "bb";
    }

    @GetMapping("cc")
    public String cc(Model model, String num1, String num2) {
        System.out.println("출력");
        if(num1 == null) num1 = "0";
        if(num2 == null) num2 = "0";
        model.addAttribute("data", "곱하기");
        model.addAttribute("result", Integer.parseInt(num1)*Integer.parseInt(num2));
        return "cc";
    }

    @GetMapping("dd")
    public String dd(Model model, String num1, String num2) {
        System.out.println("출력");
        if(num1 == null) num1 = "0";
        if(num2 == null) num2 = "0";
        model.addAttribute("data", "나누기");
        model.addAttribute("result", Integer.parseInt(num1)/Integer.parseInt(num2));
        return "dd";
    }


}
