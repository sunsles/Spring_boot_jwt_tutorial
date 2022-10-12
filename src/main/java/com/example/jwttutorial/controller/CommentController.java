package com.example.jwttutorial.controller;

import com.example.jwttutorial.dto.CommentRequestDto;
import com.example.jwttutorial.dto.MemberRequestDto;
import com.example.jwttutorial.entity.Comment;
import com.example.jwttutorial.repository.CommentRepository;
import com.example.jwttutorial.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    private final CommentRepository commentRepository;
    //댓글 생성
    @PostMapping("/api/comments")
    public Comment saveComment(@RequestBody CommentRequestDto requestDto){
        return commentService.saveCommens(requestDto);

    }
}
