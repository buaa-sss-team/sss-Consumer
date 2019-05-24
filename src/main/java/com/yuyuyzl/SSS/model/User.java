package com.yuyuyzl.SSS.model;

import javax.persistence.*;
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    public int id;

    @Column(name = "account")
    public String account;

    @Column(name = "pwd")
    public String pwd;
}
