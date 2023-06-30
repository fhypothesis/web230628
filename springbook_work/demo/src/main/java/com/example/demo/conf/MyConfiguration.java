package com.example.demo.conf;

import com.example.demo.obj.AA;
import com.example.demo.obj.BB;
import com.example.demo.obj.CC;
import com.example.demo.obj.DD;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
* 개발환경 설정 파일
* */
@Configuration
public class MyConfiguration {

    @Bean
    public AA aa() {

        return new AA("존");
    }

    @Bean
    public BB bb() {
        return new BB("sub");
    }

    @Bean
    public CC cc() {
        return new CC("mul");
    }

    @Bean
    public DD dd() {
        return new DD("div");
    }

}
