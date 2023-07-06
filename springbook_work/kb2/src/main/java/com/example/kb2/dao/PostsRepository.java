package com.example.kb2.dao;

import com.example.kb2.dto.People;
import com.example.kb2.dto.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostsRepository {

    @Autowired
    DataSource dataSource;

    public List<Post> doSelect() {
        List<Post> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement pstmt =
                    conn.prepareStatement(
                            "select * from posts"
                    );
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Post post = Post.builder()
                        .idx(rs.getInt("idx"))
                        .content(rs.getString("content"))
                        .build();

//                Post post = new Post(rs.getInt("idx")), rs.getString("content")); --> 위와 동일한 방법

                list.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn != null) try {conn.close();} catch (Exception e) {}
        }

        return list;
    }

    public void doInsert(String content) {

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement pstmt =
                    conn.prepareStatement(
                            "insert into posts (content) values (?)"
                    );
            pstmt.setString(1, content);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }

}


