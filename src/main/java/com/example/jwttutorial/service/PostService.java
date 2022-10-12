package com.example.jwttutorial.service;


import com.example.jwttutorial.dto.PostRequestDto;
import com.example.jwttutorial.dto.PostResponseDto;
import com.example.jwttutorial.entity.Post;
import com.example.jwttutorial.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service //service임을 선언
//Post클래스의 원본이 훼손되지않게 완충제역할인 dto를 통해 사용
//그래서 post클래스를 멤버변수로 가져오지않고 dto를 통해서 보내줌
public class PostService {
    //repository를 필요로함
    private final PostRepository postRepository;

    @Transactional
    //전체 게시글 목록
    public List<PostResponseDto> readPosts(){
        List<Post> post = this.postRepository.findAll();
        List<PostResponseDto> dto = new ArrayList<>();
        for(Post temp : post){
            dto.add(new PostResponseDto(temp));
        }
        return dto;
    }
    //게시글 생성
    public Post createPosts(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        return post;
    }
    //게시글 수정
    @Transactional //SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        //업데이트 :변경된 requestdto의 데이터를 post원본에 업데이트해준다
        post.update(requestDto);
        return post.getId();
    }
    //삭제
    public Long deletePost(Long id) {
        postRepository.deleteById(id);
        return id;
    }
    //비밀번호 확인
    public boolean checkPassword(Long id, String password) {
        //reposity에있는 id를 찾아서 post에 넣기
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
        //post.getPassword :기존에 있는 패스워드를 가져와서
        String check = post.getPassword();
        //check에 euns가 있으면 true, 없으면 false
        return check.equals(password);
    }

}
