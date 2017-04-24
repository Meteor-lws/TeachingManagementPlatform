package com.ruicai.education.server;

import com.ruicai.education.po.education.SystemRole;
import com.ruicai.education.po.education.UserToRoleKey;

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

    /**
     * 获取教师角色信息
     *
     * @param userId
     * @return
     */
    public List<SystemRole> getTeacherRole(String userId);

    public void deleteRoleByUserID(String userId);

    public void addRole(UserToRoleKey utr);

    /**
     * 获取所有学生角色列表
     *
     * @return 学生角色列表
     */
    public List<SystemRole> getAllStudentRole();

    public List<SystemRole> getStudentRole(String userId);
}
