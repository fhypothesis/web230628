package com.example.kb2.controller;

import com.example.kb2.dao.ProductRepository;
import com.example.kb2.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.event.MouseEvent;
import java.io.IOException;

@Controller
@RequestMapping("/product")
public class ProductController {

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
        model.addAttribute("product", dbProduct);
        return "product/view";
    }

}
