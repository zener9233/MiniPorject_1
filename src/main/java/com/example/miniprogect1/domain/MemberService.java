package com.example.miniprogect1.domain;

import com.example.miniprogect1.repository.MemberRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    //join함수 실행 ->회원가입 알아서 저장
    public void join(Member member) {
        memberRepository.save(member);
    }
    //아이디 체크하는 곳
    public int idChk(String id) {

        if (memberRepository.findByUserName(id)!= null) {
            return 1;
        }
        return 0;

    }

    //닉네임 체크하는 곳
    public int nChk(String nickname){
        if (memberRepository.findByUserNickName(nickname) != null) {
            return 1; // 닉네임이 이미 존재하는 경우
        }
        return 0; // 닉네임이 존재하지 않는 경우
    }


    ////비번 체크하는 곳
    public int pwChk(String pw) {
        if (memberRepository.findByPassword(pw) != null) {
            return 1;
        }
        return 0;
    }

    //로그인 인증 체크
    //회원가입된 유저가 맞는지 검사할 메소드
    public boolean authenticate(String userName, String password) {
        Member member = memberRepository.findByUserName(userName);

        // 조회된 회원 정보가 없거나 비밀번호가 일치하지 않는 경우
        if (member == null || !member.getPassword().equals(password)) {
            return false; // 인증 실패
        }

        return true; // 인증 성공

    }
}
