package com.example.kb3.repository;

import com.example.kb3.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {


    // select * from where username = ?1 이 생성됨
    public Member findByUsername(String username);

}
