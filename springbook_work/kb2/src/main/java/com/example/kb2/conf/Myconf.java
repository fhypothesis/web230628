package com.example.kb2.conf;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Myconf { // 객체 설정 클래스

//    public DataSource dataSource() { // 객체 주입하기
//        BasicDataSource dbs = new BasicDataSource();
//        dbs.setUrl("jdbc:mysql://localhost:3306/mydb");
//        dbs.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dbs.setUsername("root");
//        dbs.setPassword("1234");
//        dbs.setInitialSize(10); // 한꺼번에 db 10개 설정하라(설정 하지 않으면 = defalt 값(10개))
//        return dbs;
//    }  ---> 스프링부트 방식으로 개발할 땐 어플리케이션프로퍼티에 객체 주입한다.

    @Autowired
    DataSource dataSource;

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(
                applicationContext.getResources("classpath:mybatis/sql/*.xml")
        );
        return sqlSessionFactory.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(
            @Autowired SqlSessionFactory sqlSessionFactory)
            throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean());

    }

}
