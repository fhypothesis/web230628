package com.example.kb3.controller;

import com.example.kb3.dto.FreeBoardDto;
import com.example.kb3.survice.FreeBoardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;
import java.util.List;

@Controller
@RequestMapping("/FreeBoard")
public class FreeBoardController {

    @Autowired
    FreeBoardService freeBoardService;

    @GetMapping("")
    public String index(Model model, @PageableDefault(
            size = 5,
            sort = "idx",
            direction = Sort.Direction.DESC,
            page = 0 ) Pageable pageable) {
        List<FreeBoardDto> list = freeBoardService.list(pageable);
        model.addAttribute("list", list);
        return "freeboard/index";
    }

    @GetMapping("/WirteForm")
    public String gotoWirteForm(@ModelAttribute @Valid FreeBoardDto freeBoardDto, BindingResult bindingResult){
        return "freeboard/writeform";
    }

    @PostMapping("/WirteForm")
    public String WriteForm(@Valid FreeBoardDto dto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            System.out.println("사이즈 문제 있음");
            model.addAttribute("freeboarddto", dto);
            return "freeboard/writeform";
        } else {
            System.out.println(dto);
            boolean result = freeBoardService.insert(dto);
            if(result)
                return "redirect:/FreeBoard";
        }
        return "freeboard/writeform";
    }

    @GetMapping("/DetailView")
    public String gotoDetailView(@ModelAttribute @Valid FreeBoardDto freeBoardDto, BindingResult bindingResult){
        return "freeboard/detailview";
    }

}
