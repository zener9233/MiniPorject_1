package com.service;

import java.awt.*;

public class Service {
    public Point chargePoint(PointChargeDTO, int id){
        User user = userRepsitory.findUserById(id);
        dto.setUser(user);
        return porintRepository.save(mapper.map(dto, Point.class));

    }
}
