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


    @GetMapping("view")
    public String view(Model model, Product product) {
        Product dbProduct = productRepository.doSelectRow(product);
        model.addAttribute("product", dbProduct);
        return "product/view";
    }

}
