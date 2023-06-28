package com.bit.dotori.repository;


import com.bit.dotori.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CashRepository extends JpaRepository<User, Integer> {
    List<User> findTop5ByUserNameOrderByUserRegDateDesc(String userName);



}
