package com.example.kb2.dao;


import com.example.kb2.dto.People;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PeopleRepository {

    @Autowired
    SqlSession sqlSession;

    public List<People> doSelect() {
        return sqlSession.selectList("people.select");
    }

    public void doInsert(String name, int age) {
        sqlSession.insert("people.insert", People
                .builder()
                .name(name)
                .age(age)
                .build());
    }

}
