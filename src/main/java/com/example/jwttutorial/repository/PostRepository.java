package com.example.jwttutorial.repository;


import com.example.jwttutorial.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//<Post클래스 ,id역할의 자료형 Long>
//구현부가 없음
//jpa api를 가져다씀
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByModifiedAtDesc(); //내림차순

}
//