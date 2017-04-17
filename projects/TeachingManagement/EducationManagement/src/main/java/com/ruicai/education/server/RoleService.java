package com.ruicai.education.server;

import com.ruicai.education.po.education.SystemRole;

import java.util.List;

/**
 * Created by wy on 2017/4/16.
 */
public interface RoleService {
    /**
     * 查询系统角色列表
     *
     * @return 角色列表
     */
    public List<SystemRole> selectAllTeacherRole();

}
