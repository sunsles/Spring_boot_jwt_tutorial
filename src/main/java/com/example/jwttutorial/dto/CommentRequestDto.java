package com.example.jwttutorial.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequestDto {

    private String name;
    private String comment;

    public CommentRequestDto(String name, String comment){
        this.name=name;
        this.comment=comment;
    }
}
