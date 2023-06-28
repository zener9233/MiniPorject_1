package com.bit.dotori.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class User {

    @Id

    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )

    private int id;
    private Long amount;
    private Long dotori;
    private String userName;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate userRegDate = LocalDate.now();
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime userRegDateTime = LocalDateTime.now();

}
