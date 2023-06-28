package com.bit.dotori.controller;

import com.bit.dotori.entity.User;
import com.bit.dotori.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {
    private CashService cashService;
    @Autowired
    public HomeController(CashService cashService) {
        this.cashService = cashService;
    }
    @GetMapping("/")
    public ModelAndView cashList(Model model){
        List<User> userList = cashService.findAll("a");
        List<User> filteredList = new ArrayList<>();

        for (User user : userList) {
            String username = user.getUserName();
            if (username != null && username.equals("a")) { // null 값 체크
                filteredList.add(user);
            }
        }

        List<User> userList1 = cashService.finddotori();
        int sum = 0;
        for (User user : userList1) {
            String username = user.getUserName();
            if (username != null && username.equals("a")) {
                sum += user.getDotori();
            }
        }
        List<Integer> num = new ArrayList<>();


        model.addAttribute("userList", filteredList);
        model.addAttribute("sumDotori", sum);
        model.addAttribute("number", num);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index.html");
        return mv;
    }
}
