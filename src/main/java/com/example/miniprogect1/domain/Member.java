package com.example.miniprogect1.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


//테이블 구현한 곳 H_member
@Entity
@Table(name = "H_member")
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id; //이것은 고유값입니다.


    @Column(name = "userName", unique = true)
    private String userName; //이 친구가 회원가입의 "아이디" 입니다.

    @Column(name = "password")
    private String password;

    @Column(name = "user_email", unique = true)
    private String userEmail;

    @Column(name = "user_nickname", unique = true)
    private String userNickName;

    @Column(name = "reg_date")
    private LocalDateTime regDate;

    @Column(name ="user_gender")
    private String userGender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
}