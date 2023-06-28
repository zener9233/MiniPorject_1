package com.bit.dotori.service;


import com.bit.dotori.entity.User;
import com.bit.dotori.repository.CashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashService {

    private CashRepository cashRepository;
    @Autowired
    public CashService(CashRepository cashRepository) {
        this.cashRepository = cashRepository;
    }





    public void ChargeCash(User user) {
        cashRepository.save(user);
    }


    public List<User> findAll(String userName) {

        return cashRepository.findTop5ByUserNameOrderByUserRegDateDesc(userName);
    }
    public List<User> finddotori(){
        return cashRepository.findAll();
    }


}