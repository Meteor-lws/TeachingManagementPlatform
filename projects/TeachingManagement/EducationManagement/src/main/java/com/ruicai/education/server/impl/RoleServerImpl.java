package com.ruicai.education.server.impl;

import com.ruicai.education.mapper.education.SystemRoleMapper;
import com.ruicai.education.po.education.SystemRole;
import com.ruicai.education.po.education.UserToRoleKey;
import com.ruicai.education.server.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wy on 2017/4/16.
 */
@Service
public class RoleServerImpl implements RoleService {

    @Autowired
    private SystemRoleMapper systemRoleMapper;

    @Override
    public List<SystemRole> selectAllTeacherRole() {
        return systemRoleMapper.selectAllTeacher();
    }

    @Override
    public List<SystemRole> getTeacherRole(String userId) {

        return systemRoleMapper.GetTeacherRole(userId);
    }

    @Override
    public void deleteRoleByUserID(String userId) {
        systemRoleMapper.deleteRoleByUserID(userId);
    }

    @Override
    public void addRole(UserToRoleKey utr) {
        systemRoleMapper.addRole(utr);
    }
}
