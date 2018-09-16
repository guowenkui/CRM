package com.xmg.crm.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Alias("Employee")
@Setter@Getter
public class Employee {
    private Long id;

    private String username;

    private String realname;

    private String password;

    private String tel;

    private String email;

    @JsonFormat(pattern= "yyyy-MM-dd",timezone="GMT+8")
    private Date inputtime;

    private Boolean state;

    private Boolean admin;
    
    private Department dept;


}