package com.example.kb3.controller;

import com.example.kb3.entity.Member;
import com.example.kb3.survice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Member")
public class MemberCotroller {

    @Autowired
    MemberService memberService;

    // 회원가입 화면
    @GetMapping("SignUp")
    public String signup(){
        return "member/signup";
    }

    // 회원가입 후 테이블에 저장
    @PostMapping("SignUp")
    public String psignup(Member member) {
        memberService.save(member);
        return "redirect:/";
    }
}
