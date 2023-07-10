package com.example.kb2.controller;

import com.example.kb2.dao.ProductReplyRepository;
import com.example.kb2.dao.ProductRepository;
import com.example.kb2.dto.Product;
import com.example.kb2.dto.ProductReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product_reply")
public class ProductReplyController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductReplyRepository productReplyRepository;

    @GetMapping("insert")
    @ResponseBody
    public String insert(ProductReply productReply) {
        productReplyRepository.doInsert(productReply);
        return "test";
    }

    @PostMapping("insert")
//    @ResponseBody
    public String postInsert(ProductReply productReply) {
        System.out.println(productReply);
        productReply.setRef_idp_reply(productReply.getIdp_reply()); //원래 해당하는 댓글
        productReply.setRef_level(productReply.getRef_level()+1); // 깊이
        productReplyRepository.doInsert(productReply);
        return "redirect:/product/view?idp="+productReply.getIdp_product();
    }


    @GetMapping("view")
    public String view(Model model, Product product) {
        Product dbProduct = productRepository.doSelectRow(product);
        model.addAttribute("product", dbProduct);
        return "product/view";
    }

}
