package com.example.jwttutorial.dto;

import com.example.jwttutorial.entity.Authority;
import com.example.jwttutorial.entity.Member;
import lombok.*;
import org.intellij.lang.annotations.Pattern;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {
    @Pattern(regexp="([a-z]|[A-Z]|[0-9]){4,12}",
            message = "비밀번호는 알파벳 대소문자와 숫자 4자~12자의 Username 이어야 합니다.")
    private String username;
    @Pattern(regexp="([a-z]|[0-9]){4,32}",
            message = "비밀번호는 알파벳 대소문자와 숫자 6자~32자의 Password 이어야 합니다.")
    private String password;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .authority(Authority.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}