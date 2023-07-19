package com.example.kb3.controller;

import com.example.kb3.dto.FreeBoardDto;
import com.example.kb3.entity.FreeBoard;
import com.example.kb3.repository.FreeBoardRepository;
import com.example.kb3.survice.FreeBoardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/FreeBoard")
public class FreeBoardController {

    @Autowired
    FreeBoardService freeBoardService;

    @Autowired
    FreeBoardRepository freeBoardRepository;

    @GetMapping("")
    public String index(Model model, @PageableDefault(
            size = 5,
            sort = "idx",
            direction = Sort.Direction.DESC,
            page = 0 ) Pageable pageable,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "") String searchText) {
        Page<FreeBoard> pagelist = freeBoardService.list(searchText, searchText, pageable);

        // 총 행 개수
        System.out.println(pagelist.getTotalElements());
        // 총 페이지 개수
        System.out.println(pagelist.getTotalPages());
        List<FreeBoardDto> dtolist = new ArrayList<>();
        for(FreeBoard fb :pagelist){
            FreeBoardDto dto = FreeBoardDto.of(fb);
            dtolist.add(dto);
        }

        model.addAttribute("curPage", page+1);
        model.addAttribute("totalElements", pagelist.getTotalElements());
        model.addAttribute("totalPages", pagelist.getTotalPages());
        model.addAttribute("list", pagelist);
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
    public String gotoDetailView(@ModelAttribute @Valid FreeBoardDto freeBoardDto,
                                 BindingResult bindingResult,
                                 Model model){
        FreeBoardDto dto = freeBoardService.getRow(freeBoardDto);
        model.addAttribute("freeBoardDto", dto);
        return "freeboard/detailview";
    }

    @DeleteMapping("/Delete")
    public @ResponseBody String detailDelete(FreeBoardDto freeBoardDto){
        System.out.println(freeBoardDto.getIdx());
        freeBoardRepository.deleteById(freeBoardDto.getIdx());
        return "success";
    }

    @GetMapping("/UpdateForm")
    public String gotoUpdateForm(@ModelAttribute @Valid FreeBoardDto freeBoardDto,
                                 BindingResult bindingResult,
                                 Model model){
        System.out.println(freeBoardDto);
        FreeBoardDto dto = freeBoardService.getRow(freeBoardDto);
        model.addAttribute("freeBoardDto", dto);
        return "freeboard/updateform";
    }

    @PostMapping("/UpdateForm")
    public String UpdateForm(@Valid FreeBoardDto dto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            System.out.println("사이즈 문제 있음");
            model.addAttribute("freeboarddto", dto);
            return "freeboard/updateform";
        } else {
            System.out.println(dto);
            boolean result = freeBoardService.insert(dto);
            if(result)
                return "redirect:/FreeBoard";
        }
        return "freeboard/updateform";
    }

}
