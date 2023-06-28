package com.aaa.bbb.controller;

import com.aaa.bbb.maclass.Aa;
import com.aaa.bbb.maclass.Bb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AController {

    @Autowired
    Aa aa3;

    @Autowired
    Aa aa4;

    @Autowired
    Bb bb1;

    @Autowired
    Bb bb2;

    @GetMapping("aa")
    public String aa() {
        Aa aa1 = new Aa();
        Aa aa2 = new Aa();
        System.out.println("aa1 = " + aa1);
        System.out.println("aa2 = " + aa2);

        System.out.println("aa1.a = " + aa1.a);
        System.out.println("aa1.a = " + aa2.a);

        aa1.a = 20;

        System.out.println("aa1.a = " + aa1.a);
        System.out.println("aa2.a = " + aa2.a);

        aa3.a = 40;

        System.out.println("aa3.a = " + aa3.a);
        System.out.println("aa4.a = " + aa4.a);


        System.out.println("aa3 = " + aa3);
        System.out.println("aa4 = " + aa4);

        return "gamjaisback";
    }

    @GetMapping("bb")
    public String bb() {
        System.out.println("bb1 = " + bb1);
        System.out.println("bb2 = " + bb2);

        System.out.println("bb1.c = " + bb1.c);
        System.out.println("bb2.c = " + bb2.c);

        bb1.c = 30;

        System.out.println("bb1.c = " + bb1.c);
        System.out.println("bb2.c = " + bb2.c);

        return "honggamja";
    }

}
