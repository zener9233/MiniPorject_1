package com.example.miniprogect1.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ilchonpatch")
public class Ilchonpatch {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long Id;
    private String request;
    private String nickName;

}
