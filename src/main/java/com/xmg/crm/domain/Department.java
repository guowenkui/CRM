package com.xmg.crm.domain;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Alias("Department")
@Setter@Getter
public class Department {
    private Long id;

    private String sn;

    private String name;

    private Long managerId;

    private Long parentId;

    private Boolean state;
}