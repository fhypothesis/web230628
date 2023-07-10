package com.example.kb2.dao;


import com.example.kb2.dto.Product;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    SqlSession sqlSession;

    public List<Product> doSelect() {
        return sqlSession.selectList("product.select");
    }

  /*  public void doInsert(String productName, int purchasesNum) {
        sqlSession.insert("product.insert", Product
                .builder()
                .productName(productName)
                .purchasesNum(purchasesNum)
                .build());
    }*/

    public void doInsert(Product product) {
        sqlSession.insert("product.insert", product);
    }

    public Product doSelectRow(Product product) {
        return sqlSession.selectOne("product.select_row", product);
    }

}
