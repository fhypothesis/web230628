package com.example.kb3.dto;

import com.example.kb3.entity.FreeBoard;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Getter
@Setter
public class FreeBoardDto {

    private int idx;
    private String name;
    private String title;
    private String content;
    private LocalDateTime createDate;

    private static ModelMapper modelMapper = new ModelMapper();

    public FreeBoard createFreeBoard(){
        return modelMapper.map(this, FreeBoard.class);
    }
    public static FreeBoardDto of(FreeBoard freeBoard){
        return modelMapper.map(freeBoard, FreeBoardDto.class);
    }

}
