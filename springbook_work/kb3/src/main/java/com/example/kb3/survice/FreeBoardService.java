package com.example.kb3.survice;

import com.example.kb3.dto.FreeBoardDto;
import com.example.kb3.entity.FreeBoard;
import com.example.kb3.repository.FreeBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FreeBoardService {

    @Autowired
    FreeBoardRepository freeBoardRepository;
    public List<FreeBoardDto> list() {
        // 데이터베이스에 가서 select 해서 내용을 가지고 와서 list에 담는다
        Page<FreeBoard> list = freeBoardRepository.findAll(
                PageRequest.of(0, 5));
        System.out.println("page = " + list);
        // list에 담긴 FreeBoard를 FreeBoardDto로 변경해서 list에 다시 담는다
        List<FreeBoardDto> dtolist = new ArrayList<>();
        for(FreeBoard fb :list){
            FreeBoardDto dto = FreeBoardDto.of(fb);
            dtolist.add(dto);
        }

        System.out.println("dtolist = " + dtolist);
        return dtolist;
    }
}
