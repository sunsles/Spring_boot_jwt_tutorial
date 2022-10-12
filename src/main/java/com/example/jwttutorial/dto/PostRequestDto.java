package com.example.jwttutorial.dto;

import lombok.Getter;
import lombok.Setter;

//
//게시글 작성
//dto - 새롭게 데이터를 등록 ,변경할때 담는 상자
//post클래스를 건드리지않고 dto에서 변경될 데이터를 보내줘야함
@Getter
@Setter
public class PostRequestDto {
    private String title; //제목
    private String username; //명
    private String password; //비밀번호
    private String content; //코멘트

    public PostRequestDto(String title,String username,String password, String content){
        this.title =title;
        this.username= username;
        this.password= password;
        this.content=content;
    }

}
