package com.example.kb2.controller;

import com.example.kb2.dao.PeopleReplyRepository;
import com.example.kb2.dao.PeopleRepository;
import com.example.kb2.dto.People;
import com.example.kb2.dto.PeopleReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/people_reply")
public class PeopleReplyController {

    @Autowired
    PeopleRepository peopleRepository;
    @Autowired
    PeopleReplyRepository peopleReplyRepository;

    @GetMapping("insert")
    @ResponseBody
    public String insert(PeopleReply peopleReply) {
        peopleReplyRepository.doInsert(peopleReply);
        return "test";
    }


    @GetMapping("view")
    public String view(Model model, People people) {
        People dbPeople = peopleRepository.doSelectRow(people);
        model.addAttribute("people", dbPeople);
        return "people/view";
    }

}
