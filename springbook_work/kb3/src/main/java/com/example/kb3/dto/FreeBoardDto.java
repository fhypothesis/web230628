package com.example.kb3.dto;

import com.example.kb3.entity.FreeBoard;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class FreeBoardDto {

    private int idx;
    private String name;

    @Size(min = 3, max = 30, message = "3자 이상 써주세요")
    private String title;
    @Size(min = 3, max = 30, message = "3자 이상 써주세요")
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
