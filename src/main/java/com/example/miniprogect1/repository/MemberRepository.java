package com.example.miniprogect1.repository;

import com.example.miniprogect1.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
//    public Member findByUsername(String id);
    Member findByUserName(String userName);

    Member findByPassword(String password);

    Member findByUserNickName(String userNickName);

}
