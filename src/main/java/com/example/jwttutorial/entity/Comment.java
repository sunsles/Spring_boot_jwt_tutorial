package com.example.jwttutorial.entity;

import com.example.jwttutorial.dto.CommentRequestDto;

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
    private String name;
    @Column(nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name="USER_ID", nullable = false)
    private Post post;

    public Comment(String name,String comment,Post post){
        this.name=name;
        this.comment=comment;
        this.post=post;

    }
    public Comment(CommentRequestDto requestDto) {
        this.name=requestDto.getName();
        this.comment=requestDto.getComment();
    }
}
