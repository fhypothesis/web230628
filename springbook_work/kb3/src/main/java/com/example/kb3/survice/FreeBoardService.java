package com.example.kb3.survice;

import com.example.kb3.dto.FreeBoardDto;
import com.example.kb3.entity.FreeBoard;
import com.example.kb3.repository.FreeBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FreeBoardService {

    @Autowired
    FreeBoardRepository freeBoardRepository;
    public List<FreeBoardDto> list(Pageable pageable) {
//       위의 내용을 요렇게 적어도 된다--> Pageable pageable = PageRequest.of(0, 5, Sort.by("idx").descending()));
        Page<FreeBoard> pagelist = freeBoardRepository.findAll(pageable);
        List<FreeBoardDto> dtolist = new ArrayList<>();
        for(FreeBoard fb :pagelist){
            FreeBoardDto dto = FreeBoardDto.of(fb);
            dtolist.add(dto);
        }

        System.out.println("dtolist = " + dtolist);
        return dtolist;
    }

    public boolean insert(FreeBoardDto dto) {
        FreeBoard freeBoard = dto.createFreeBoard();
        freeBoardRepository.save(freeBoard);
        return true;
    }

}
