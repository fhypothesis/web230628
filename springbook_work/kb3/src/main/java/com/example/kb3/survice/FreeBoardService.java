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
    public Page<FreeBoard> list(String searchText, String SearchText, Pageable pageable) {
//       위의 내용을 요렇게 적어도 된다--> Pageable pageable = PageRequest.of(0, 5, Sort.by("idx").descending()));
        Page<FreeBoard> pagelist = freeBoardRepository.findByTitleContainingOrContentContaining(
                searchText, SearchText, pageable);
        System.out.println(pagelist.getContent());
        return pagelist;
    }

    public boolean insert(FreeBoardDto dto) {
        // 작성일자 없어지는 거 수정
        FreeBoard freeBoardEntity = freeBoardRepository.findById(dto.getIdx()).orElse(new FreeBoard());
        freeBoardEntity.setContent(dto.getContent());
        freeBoardEntity.setName(dto.getName());
        freeBoardEntity.setTitle(dto.getTitle());
        freeBoardRepository.save(freeBoardEntity);
        return true;
    }

    public FreeBoardDto getRow(FreeBoardDto freeBoardDto) {
        FreeBoard freeBoard = freeBoardRepository.findById(freeBoardDto.getIdx())
                .orElse(new FreeBoard());
        return FreeBoardDto.of(freeBoard);
    }
}
