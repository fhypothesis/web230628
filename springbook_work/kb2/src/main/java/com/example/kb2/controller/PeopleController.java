package com.example.kb2.controller;

import com.example.kb2.dao.PeopleReplyRepository;
import com.example.kb2.dao.PeopleRepository;
import com.example.kb2.dto.People;
import com.example.kb2.dto.PeopleReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    PeopleReplyRepository peopleReplyRepository;

    @Autowired
    PeopleRepository peopleRepository;

    @PostMapping("insert")
    public String insert(People people) {
        peopleRepository.doInsert(people);
        return "redirect:/";
    }

    @GetMapping("view")
    public String view(Model model, People people) {
        People dbPeople = peopleRepository.doSelectRow(people);
        PeopleReply peopleReply = PeopleReply
                .builder()
                .idx_people(people.getIdx())
                .build();
        List<PeopleReply> peopleReplyList = peopleReplyRepository.doSelect(peopleReply);
        model.addAttribute("people", dbPeople);
        model.addAttribute("peopleReplyList", peopleReplyList);
        return "people/view";
    }

}
