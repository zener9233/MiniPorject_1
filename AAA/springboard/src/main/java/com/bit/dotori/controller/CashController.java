package com.bit.dotori.controller;


import com.bit.dotori.entity.User;
import com.bit.dotori.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cash")
public class CashController {

    private CashService cashService;

    @Autowired
    public CashController(CashService cashService) {
        this.cashService = cashService;
    }
    @PostMapping("/cash/point")
    public @ResponseBody void CashCharge(@RequestParam Long amount) {
        User user = new User();
        user.setUserName("a");
        user.setAmount(amount);
        user.setDotori(amount/100);
        cashService.ChargeCash(user);
    }


}