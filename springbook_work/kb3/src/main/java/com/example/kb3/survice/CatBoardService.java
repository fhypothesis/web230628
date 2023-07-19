package com.example.kb3.survice;

import com.example.kb3.dto.CatBoardDto;
import com.example.kb3.dto.FreeBoardDto;
import com.example.kb3.entity.CatBoard;
import com.example.kb3.entity.FreeBoard;
import com.example.kb3.repository.CatBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatBoardService {

    @Autowired
    CatBoardRepository catBoardRepository;
    public List<CatBoardDto> list(Pageable pageable) {
        Page<CatBoard> pagelist = catBoardRepository.findAll(pageable);
        List<CatBoardDto> dtolist = new ArrayList<>();
        for(CatBoard cb :pagelist){
            CatBoardDto dto = CatBoardDto.of(cb);
            dtolist.add(dto);
        }

        System.out.println("dtolist = " + dtolist);
        return dtolist;
    }

    public boolean insert(CatBoardDto dto) {
        CatBoard catBoardEntity = catBoardRepository.findById(dto.getIdx()).orElse(new CatBoard());
        catBoardEntity.setContent(dto.getContent());
        catBoardEntity.setName(dto.getName());
        catBoardEntity.setTitle(dto.getTitle());
        catBoardRepository.save(catBoardEntity);
        return true;
    }

    public CatBoardDto getRow(CatBoardDto catBoardDto) {
        CatBoard catBoard = catBoardRepository.findById(catBoardDto.getIdx())
                .orElse(new CatBoard());
        return CatBoardDto.of(catBoard);
    }
}
