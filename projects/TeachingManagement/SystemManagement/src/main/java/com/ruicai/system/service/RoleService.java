package com.ruicai.system.service;

import com.ruicai.system.po.system.RoleToResourceKey;
import com.ruicai.system.po.system.SystemRole;
import com.ruicai.system.vo.RoleShow;
import com.ruicai.system.vo.Tree;

import java.util.List;

/**
 * Created by 朱高 on 2017/4/25.
 */
public interface RoleService {

    List<Tree> findRoleTree();

    void addRole(SystemRole role, String resourceId);

    List<RoleShow> findRoleDetails(RoleShow roleShow);

    void deleteRoleById(String id);

    void deleteResourceByIds(RoleToResourceKey roleToResourceKey);

    void updateRole(SystemRole role, String resourceId);
}
