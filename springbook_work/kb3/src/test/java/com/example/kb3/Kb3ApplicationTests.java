package com.example.kb3;

import com.example.kb3.entity.FreeBoard;
import com.example.kb3.entity.QFreeBoard;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Kb3ApplicationTests {

	@Autowired
	JPAQueryFactory jpaQueryFactory;

	@Test
	void contextLoads() {
		JPAQuery<FreeBoard> query =
				jpaQueryFactory.selectFrom(QFreeBoard.freeBoard);
		System.out.println(query);

		List<FreeBoard> list = query.fetch();
		System.out.println(list);
	}

}
