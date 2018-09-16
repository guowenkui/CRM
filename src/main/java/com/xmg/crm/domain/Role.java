package com.xmg.crm.domain;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
@Alias("Role")
public class Role {
    private Long id;
    private String name;
    private String sn;
    private List<Permission> permissions; 
}