package com.example.kb3.survice;

import com.example.kb3.dto.CatBoardDto;
import com.example.kb3.entity.CatBoard;
import com.example.kb3.repository.CatBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        CatBoard catBoard = dto.createCatBoard();
        catBoardRepository.save(catBoard);
        return true;
    }

    public Optional<CatBoardDto> detailByIdx(int idx) {
        Optional<CatBoardDto> boardDtoList = catBoardRepository.findById(idx).map(CatBoardDto::of);
        return boardDtoList;
    }
}
