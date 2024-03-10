package com.baomili.mall.modules.admin.vo;

import lombok.Data;

import java.util.List;

@Data
public class UserInfo {
    private List<String> roles;

    private String name;

    private String avatar;

    private String introduction;
}
