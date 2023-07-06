package com.example.kb2.controller;

import com.example.kb2.dao.PeopleRepository;
import com.example.kb2.dao.PostsRepository;
import com.example.kb2.dao.ProductRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.sql.DataSource;
import java.io.IOException;

@Controller
public class AController {

    @Autowired // 객체 불러오기
    DataSource ds;

    @Autowired
    PostsRepository postsRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PeopleRepository peopleRepository;

    @Autowired
    SqlSession sqlSession;

    @GetMapping("/")
    public String index(Model model) throws IOException { // 모델 사용하여 db에서 불러온 데이터를 html 파일로 가져감

      /*  ArrayList<People> al = new ArrayList<>();
        ArrayList<Product> product = new ArrayList<>();
        // 리스트 한번 더 만들어준다.
        Connection conn = null;
        // 외부에서 커넥션 해줌. 단, 업데이트는 공용으로 쓰지 않음

        try {
            conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from people");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idx = rs.getInt("idx");
                String name = rs.getString("name");
                String age = rs.getString("age");
                // 스트링에 name과 age 담기
                People temp = new People(idx, name, age);
//                temp.setAge(Age);
//                temp.setName(name);
                al.add(temp);
                // al에 name과 age 담기
            }
            pstmt = conn.prepareStatement("select * from product");
            rs = pstmt.executeQuery();
            // 위에서 선언한 거 쿼리문만 바꿔서 재활용함.
            while (rs.next()) {
                int idp = rs.getInt("idp");
                String productName = rs.getString("product_name");
                int purchasesNum = rs.getInt("purchases_num");
                int peopleIdx = rs.getInt("people_idx");
                Product p = new Product(idp, productName, purchasesNum, peopleIdx);
                // 형 다르기 때문에 객체 순서 바뀌면 오류남
                product.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn != null) try {conn.close();} catch (Exception e) {}
            // db 연결하고 나면 db 연결을 끊어줘야 한다
        }
*/

        model.addAttribute("al", peopleRepository.doSelect());
        // 모델에 담은 데이터는 al에 담아 한 번만 보내면 됨
        model.addAttribute("product", productRepository.doSelect());
        model.addAttribute("post", postsRepository.doSelect());
        // 포스트레퍼지토리의 두포스트셀렉트(쿼리문 담긴 함수)를 불러온다(포스트는 jsp 방식으로 레퍼지토리 만듦)
        return "index";
    }

    @PostMapping("/post")
    public String post(String content, HttpServletRequest request) {
        postsRepository.doInsert(content);
        return "redirect:/"; // 저장하고 root 페이지로 이동하라
    }

    @PostMapping("/people")
    public String people(String name, int age, HttpServletRequest request) {
        peopleRepository.doInsert(name, age);
        return "redirect:/";
    }


}
