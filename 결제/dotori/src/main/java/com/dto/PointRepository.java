package com.dto;

import org.springframework.transaction.annotation.Transactional;

import java.awt.*;

public interface PointRepository extends JpaRepository<Point, Long> {

    List<Point> findAllByUser(User user);

    @Transactional
    @Query("select sum(p.amount) from Point p where p.user = ?1")
    Long amountSum(User user);
}