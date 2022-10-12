package com.example.jwttutorial.service;

import com.example.jwttutorial.dto.CommentRequestDto;
import com.example.jwttutorial.entity.Comment;
import com.example.jwttutorial.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment saveCommens(CommentRequestDto requestDto){
        Comment comment = new Comment(requestDto);
        commentRepository.save(comment);
        return comment;
    }
}
