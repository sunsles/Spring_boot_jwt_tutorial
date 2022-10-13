package com.example.jwttutorial.controller;

import com.example.jwttutorial.dto.CommentDto;
import com.example.jwttutorial.entity.Comment;
import com.example.jwttutorial.entity.Post;
import com.example.jwttutorial.repository.CommentRepository;
import com.example.jwttutorial.repository.PostRepository;
import com.example.jwttutorial.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    //댓글 생성
    @PostMapping("/comments")
    public void saveComment(@RequestBody CommentDto commentDto){
        commentService.saveComment(commentDto);
    }
    //하나조회
    @GetMapping("/comments/{id}")
    public Comment findOneComment(@PathVariable Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
    }
    //전체조회
    @GetMapping("/comments")
    public List<Comment> finAllComment(){
        return commentRepository.findAll();
    }

    @PutMapping("/comments/{id}")
    public Long updateComment(@PathVariable Long id, @RequestBody CommentDto commentDto){
        commentService.update(id,commentDto);
        return id;
    }
    @DeleteMapping("/comments/{id}")
    public Long deleteComment(@PathVariable Long id){
        commentRepository.deleteById(id);
        return id;
    }
}
