package com.example.miniprogect1.controller;

import com.example.miniprogect1.domain.Member;
import com.example.miniprogect1.domain.MemberService;
import com.example.miniprogect1.repository.MemberRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.Map;


@Controller
public class UserController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public UserController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
    }

    //회원가입 화면으로 이동
    @GetMapping("/join")
    public String joinView() {
        return "join";
    }

    //회원가입 처리
    @PostMapping("/join")
    public String join(Member member) {
        member.setRegDate(LocalDateTime.now());
        memberService.join(member);

        return "Login";
    }

    //로그인 화면 으로 이동
    @GetMapping("/")
    public String loginView() {

        return "Login";
    }


    //로그인 처리
    @PostMapping("/login")
    public String login(Member member, RedirectAttributes redirectAttributes) {
        System.out.println(member);
        try {
            if (memberService.authenticate(member.getUserName(), member.getPassword())) {
                // 인증 성공
                // 세션 등에 로그인 정보를 저장하고, 접근 권한을 부여할 수 있습니다.
                // 로그인 성공 알림창
                redirectAttributes.addFlashAttribute("successMessage", "로그인 성공! HELLO WORLD :)");
                return "home";
            } else {
                // 인증 실패
                // 로그인 실패 알림창
                System.out.println("fail");
                redirectAttributes.addFlashAttribute("errorMessage", "회원정보가 일치하지 않습니다. 다시 시도해주세요.");
                return "/login";
            }
        } catch (Exception e) {
            // 예외 처리
            System.out.println(e.getMessage());
            redirectAttributes.addFlashAttribute("errorMessage", "로그인 과정에서 오류가 발생했습니다. 다시 시도해주세요.");
            return "/login";
        }
    }





    @ResponseBody
    @RequestMapping("/idCheck")
    public int idCheck(@RequestParam("userName") String userName) {
        System.out.println(userName);
        int idCheck = memberService.idChk(userName);

        if (idCheck > 0) {
            // 중복된 아이디
            return 1;
        } else {
            // 사용 가능한 아이디
            return 0;
        }
    }

    @ResponseBody
    @RequestMapping("/NickNameCheck")
    public int nicknameCheck(@RequestParam("userNickName") String userNickName) {
        System.out.println(userNickName);
        int nicknameCheck = memberService.nChk(userNickName);

        if (nicknameCheck > 0) {
            // 중복된 닉네임
            return 1;
        } else {
            // 사용 가능한 닉네임
            return 0;
        }
    }






}
