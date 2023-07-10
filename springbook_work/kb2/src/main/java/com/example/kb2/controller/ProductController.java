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

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductReplyRepository productReplyRepository;

    @Autowired
    ProductRepository productRepository;

    @PostMapping("insert")
    public String insert(Product product) {
        productRepository.doInsert(product);
        return "redirect:/";
    }

    @GetMapping("view")
    public String view(Model model, Product product) {
        Product dbProduct = productRepository.doSelectRow(product);
        ProductReply productReply = ProductReply
                .builder()
                .idp_product(product.getIdp())
                .build();
        List<ProductReply> productReplyList = productReplyRepository.doSelect(productReply);
        model.addAttribute("product", dbProduct);
        model.addAttribute("productReplyList", productReplyList);
        return "product/view";
    }

}
