package com.example.jwttutorial.dto;

import com.example.jwttutorial.entity.Comment;
import com.example.jwttutorial.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentDto {

    private String contents;

    private Long postid;

    public CommentDto(Comment comment){
        this.contents= comment.getContents();
    }

}
