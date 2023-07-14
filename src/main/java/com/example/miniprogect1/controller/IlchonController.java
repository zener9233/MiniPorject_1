package com.example.miniprogect1.controller;

import com.example.miniprogect1.Service.IlchonService;
import com.example.miniprogect1.domain.Ilchon;
import com.example.miniprogect1.domain.Ilchonpatch;
import com.example.miniprogect1.domain.User;
import com.example.miniprogect1.repository.IlchonpatchRepository;
import com.example.miniprogect1.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ilchon")
public class IlchonController {
    private final MemberRepository memberRepository;
    private IlchonService ilchonService;
    private final IlchonpatchRepository ilchonpatchRepository;

    @Autowired
    public IlchonController(MemberRepository memberRepository, IlchonService ilchonService, IlchonpatchRepository ilchonpatchRepository) {
        this.memberRepository = memberRepository;
        this.ilchonService = ilchonService;
        this.ilchonpatchRepository = ilchonpatchRepository;
    }

    @GetMapping("/MiniMain-view/{userid}")
    public String addIlchon(@PathVariable("userid") Long uId, HttpSession session, Model model) {
        // memberRepository를 사용하여 사용자의 아이디에 해당하는 닉네임을 가져옵니다.
        System.out.println("uId============================> " + uId);
        User name = memberRepository.findById(uId).get();
        String st = name.getUserNickName();
        System.out.println(st+"@@@@@@@@@@@@@@@@@@@@@@@");
        model.addAttribute("guess", st);
        //일촌 테이블에 신청자, 받은사람 insert되도록
        // 예시 응답: "일촌신청이 완료되었습니다!"
        return st;
    }


    @GetMapping("/beak")
    public String processFriendRequest(@RequestParam("count") int count, @RequestParam("userName") String userName, HttpSession session) {
        // count와 userName 정보를 받아서 원하는 로직을 구현합니다.
        // 예시로 콘솔에 출력하고 응답을 반환하는 코드를 작성했습니다.
        User loginUser = (User) session.getAttribute("loginUser");

        System.out.println("count: " + count);
        System.out.println("userName: " + userName);
        System.out.println("loginName : "+ loginUser.getUserNickName());
        Ilchonpatch Ilch = new Ilchonpatch();
        Ilchon Ic = new Ilchon();
        if(count == 1)
        {
            Ilch.setRequest(userName);
            Ilch.setNickName(loginUser.getUserNickName());
            ilchonService.addrequest(Ilch);
        }
        else if(count == 2) {
            Ic.setMe(userName);
            Ic.setYou(loginUser.getUserNickName());
            System.out.println(Ic.getMe());
            ilchonService.addfirinds(Ic);
            Ilchon Ic2 = new Ilchon();
            Ic2.setMe(loginUser.getUserNickName());
            Ic2.setYou(userName);
            System.out.println(Ic.getMe());
            ilchonService.addfirinds(Ic2);

            List<Ilchonpatch> cut = ilchonService.trash(loginUser.getUserNickName(), userName);
            for( Ilchonpatch trsr : cut )
            {
                ilchonService.deletefriends(trsr);
            }


        }
        else if(count == 3)
        {
            List<Ilchonpatch> cut = ilchonService.trash(loginUser.getUserNickName(), userName);
            for( Ilchonpatch trsr : cut )
            {
                ilchonService.deletefriends(trsr);
            }
        }

        return null;
    }

    /*@GetMapping("/home")
    public int alert(HttpSession session){
        User loginUser = (User) session.getAttribute("loginUser");
        int count = 0;
        List<Ilchonpatch> holi = ilchonService.gust(loginUser.getUserNickName());
        for(Ilchonpatch IlP : holi)
        {
            String username = IlP.getRequest();
            if(username.equals(loginUser.getUserNickName()))
            {
                count++;
            }
        }
        System.out.println(count+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return count;
    }*/
}