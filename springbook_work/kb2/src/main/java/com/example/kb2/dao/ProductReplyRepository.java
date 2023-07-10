package com.example.kb2.dao;


import com.example.kb2.dto.Product;
import com.example.kb2.dto.ProductReply;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductReplyRepository {

    @Autowired
    SqlSession sqlSession;

    public List<ProductReply> doSelect(ProductReply productReply) {
        return sqlSession.selectList("product_reply.select", productReply);
    }

    public void doInsert(ProductReply productReply) {
        sqlSession.insert("product_reply.insert", productReply);
    }

    public Product doSelectRow(ProductReply product) {
        return sqlSession.selectOne("product_reply.select_row", product);
    }

}
