package com.yuyuyzl.SSS.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "account")
    private String account;

    @Column(name = "pwd")
    private String pwd;

    public String getAccount(){return this.account;}
    public void setAccount(String s){this.account = s;}
    public String getPwd(){return this.pwd;}
    public void setPwd(String s){this.pwd = s;}
    public int getId(){return this.id;}
}
