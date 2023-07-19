package com.example.kb3.dto;

import com.example.kb3.entity.CatBoard;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Getter
@Setter
public class CatBoardDto {

    private int idx;
    private String name;

    @Size(min = 3, max = 30, message = "3자 이상 써주세요")
    private String title;
    @Size(min = 3, max = 30, message = "3자 이상 써주세요")
    private String content;

    private LocalDateTime createDate;

    private static ModelMapper modelMapper = new ModelMapper();

    public CatBoard createCatBoard(){
        return modelMapper.map(this, CatBoard.class);
    }
    public static CatBoardDto of(CatBoard catBoard){
        return modelMapper.map(catBoard, CatBoardDto.class);
    }

}
