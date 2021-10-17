package com.example.project2.entities;

import lombok.Data;

import javax.persistence.*;


@Table(name="TB_USER")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    private Integer id;
    @Column(name="USER_NAME")
    private String userName;
    @Column(name="USER_EMAIL")
    private String email;
    @Column(name="USER_AVATAR")
    private String avatarURL;
    @Column(name="USER_LEVEL")
    private UserLevel userLevel;

}
