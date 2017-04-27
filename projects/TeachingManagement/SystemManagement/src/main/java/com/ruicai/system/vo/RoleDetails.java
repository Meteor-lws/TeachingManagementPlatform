package com.ruicai.system.vo;

import com.ruicai.system.po.system.SystemRole;

import java.util.List;

/**
 * Created by 朱高 on 2017/4/27.
 */
public class RoleDetails extends SystemRole {
    private List<RoleShow> list;

    public List<RoleShow> getList() {
        return list;
    }

    public void setList(List<RoleShow> list) {
        this.list = list;
    }

}
