package com.example.jwttutorial.service;

import com.example.jwttutorial.dto.CommentDto;
import com.example.jwttutorial.entity.Comment;
import com.example.jwttutorial.entity.Post;
import com.example.jwttutorial.repository.CommentRepository;
import com.example.jwttutorial.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    //댓글 저장
    public void saveComment(CommentDto commentDto) {
        Post post = postRepository.findById(commentDto.getPostid()).orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
        Comment comment = new Comment(commentDto, post);
        commentRepository.save(comment);
    }
    //댓글 수정
    @Transactional
    public Long update(Long id, CommentDto commentDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        comment.update(commentDto);
        return comment.getId();
    }

}
