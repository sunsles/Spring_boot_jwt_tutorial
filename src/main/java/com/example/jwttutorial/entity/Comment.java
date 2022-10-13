package com.example.jwttutorial.entity;

import com.example.jwttutorial.dto.CommentDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name="post_id", nullable = false)
    private Post post;

    public Comment(CommentDto commentDto, Post post) {
        this.contents = commentDto.getContents();
        this.post = post;
    }
    public void update(CommentDto commentDto){
        this.contents =commentDto.getContents();
    }

}
