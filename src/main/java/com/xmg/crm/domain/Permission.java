package com.xmg.crm.domain;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
@Alias("Permission")
public class Permission {
    private Long id;
    private String name;
    private String resource;

}