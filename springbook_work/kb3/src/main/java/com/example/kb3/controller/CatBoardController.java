package com.example.kb3.controller;

import com.example.kb3.dto.CatBoardDto;
import com.example.kb3.dto.FreeBoardDto;
import com.example.kb3.entity.CatBoard;
import com.example.kb3.entity.FreeBoard;
import com.example.kb3.repository.CatBoardRepository;
import com.example.kb3.survice.CatBoardService;
import com.example.kb3.survice.FreeBoardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/CatBoard")
public class CatBoardController {

    @Autowired
    CatBoardService catBoardService;

    @Autowired
    CatBoardRepository catBoardRepository;

    @GetMapping("")
    public String index(Model model, @PageableDefault(
            size = 5,
            sort = "idx",
            direction = Sort.Direction.DESC,
            page = 0 ) Pageable pageable,
    @RequestParam(required = false, defaultValue = "0") int page) {

        Page<CatBoard> pagelist = catBoardService.list(pageable);

        // 총 행 개수
        System.out.println(pagelist.getTotalElements());
        // 총 페이지 개수
        System.out.println(pagelist.getTotalPages());
        List<CatBoardDto> dtolist = new ArrayList<>();
        for(CatBoard cb :pagelist) {
            CatBoardDto dto = CatBoardDto.of(cb);
            dtolist.add(dto);
        }

        model.addAttribute("curPage", page+1);
        model.addAttribute("totalElements", pagelist.getTotalElements());
        model.addAttribute("totalPages", pagelist.getTotalPages());
        model.addAttribute("list", pagelist);
        return "catboard/index";
    }

    @GetMapping("/WirteForm")
    public String gotoWirteForm(@ModelAttribute @Valid CatBoardDto catBoardDto, BindingResult bindingResult){
        return "catboard/writeform";
    }

    @PostMapping("/WirteForm")
    public String WriteForm(@Valid CatBoardDto dto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            System.out.println("사이즈 문제 있음");
            model.addAttribute("catboarddto", dto);
            return "catboard/writeform";
        } else {
            System.out.println(dto);
            boolean result = catBoardService.insert(dto);
            if(result)
                return "redirect:/CatBoard";
        }
        return "catboard/writeform";
    }

    @GetMapping("/DetailView")
    public String gotoDetailView(@ModelAttribute @Valid CatBoardDto catBoardDto,
                                 BindingResult bindingResult,
                                 Model model){
        CatBoardDto dto = catBoardService.getRow(catBoardDto);
        model.addAttribute("catBoardDto", dto);
        return "catboard/detailview";
    }

    @DeleteMapping("/Delete")
    public @ResponseBody String detailDelete(CatBoardDto catBoardDto){
        System.out.println(catBoardDto.getIdx());
        catBoardRepository.deleteById(catBoardDto.getIdx());
        return "success";
    }

    @GetMapping("/UpdateForm")
    public String gotoUpdateForm(@ModelAttribute @Valid CatBoardDto catBoardDto,
                                 BindingResult bindingResult,
                                 Model model){
        CatBoardDto dto = catBoardService.getRow(catBoardDto);
        model.addAttribute("catBoardDto", dto);
        return "catboard/updateform";
    }

    @PostMapping("/UpdateForm")
    public String UpdateForm(@Valid CatBoardDto dto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("catBoardDto", dto);
            return "catboard/updateform";
        } else {
            System.out.println(dto);
            boolean result = catBoardService.insert(dto);
            if(result)
                return "redirect:/CatBoard";
        }
        return "catboard/updateform";
    }

}
