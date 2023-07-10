package com.example.kb2.dao;


import com.example.kb2.dto.People;
import com.example.kb2.dto.PeopleReply;
import com.example.kb2.dto.ProductReply;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeopleReplyRepository {

    @Autowired
    SqlSession sqlSession;

    public List<PeopleReply> doSelect(PeopleReply peopleReply) {
        return sqlSession.selectList("people_reply.select", peopleReply);
    }

    public void doInsert(PeopleReply peopleReply) {
        sqlSession.insert("people_reply.insert", peopleReply);
    }

    public People doSelectRow(ProductReply people) {
        return sqlSession.selectOne("people_reply.select_row", people);
    }

}
