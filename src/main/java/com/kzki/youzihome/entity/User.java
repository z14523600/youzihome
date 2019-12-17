package com.kzki.youzihome.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    public int id;
    public String pwd;
    public Date birthday;
}
