package com.ruicai.system.service.impl;

import com.ruicai.system.mapper.system.SystemRoleMapper;
import com.ruicai.system.po.system.RoleToResourceKey;
import com.ruicai.system.po.system.SystemRole;
import com.ruicai.system.po.system.SystemRoleExample;
import com.ruicai.system.service.RoleService;
import com.ruicai.system.vo.RoleShow;
import com.ruicai.system.vo.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱高 on 2017/4/25.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private final SystemRoleMapper roleMapper;

    public RoleServiceImpl(SystemRoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<Tree> findRoleTree() {
        List<Tree> treeList = new ArrayList<>();
        SystemRoleExample roleExample = new SystemRoleExample();
        roleExample.clear();
        roleExample.createCriteria().andParentIdIsNull();
        for (SystemRole role : roleMapper.selectByExample(roleExample)) {
            treeList.add(buildTree(role));
        }
        return treeList;
    }

    @Override
    public void addRole(SystemRole role, String resourceIds) {
        roleMapper.insert(role);
        int i = roleMapper.addResToRoleBatch(getRoleToRes(role, resourceIds));
        System.err.println("i = " + i);
    }

    @Override
    public List<RoleShow> findRoleDetails(RoleShow roleShow) {
        return roleMapper.findRoleDetails(roleShow);
    }

    @Override
    public void deleteRoleById(String id) {
        roleMapper.deleteByPrimaryKey(id);
        SystemRoleExample roleExample = new SystemRoleExample();
        roleExample.clear();
        roleExample.createCriteria().andParentIdEqualTo(id);
        roleMapper.deleteByExample(roleExample);
    }

    @Override
    public void deleteResourceByIds(RoleToResourceKey roleToResourceKey) {
        roleToResourceKey.setIds(roleToResourceKey.getResId().split(","));
        roleMapper.deleteResourceByIds(roleToResourceKey);
    }

    @Override
    public void updateRole(SystemRole role, String resourceIds) {
        SystemRoleExample roleExample = new SystemRoleExample();
        roleExample.clear();
        roleExample.createCriteria().andIdEqualTo(role.getId());
        roleMapper.updateByPrimaryKeySelective(role);
        roleMapper.deleteRoleToRes(role.getId());
        roleMapper.addResToRoleBatch(getRoleToRes(role, resourceIds));
    }

    public Tree buildTree(SystemRole role) {
        Tree tree = new Tree();
        tree.setId(role.getId());
        tree.setText(role.getRoleName());
        tree.setChildren(getChildren(role.getId()));
        return tree;
    }

    public List<Tree> getChildren(String id) {
        List<Tree> treeList = new ArrayList<>();
        SystemRoleExample roleExample = new SystemRoleExample();
        roleExample.clear();
        roleExample.createCriteria().andParentIdEqualTo(id);
        //roleExample.setOrderByClause("DICTIONARY_TYPE_SORT_NUMBER ASC");
        for (SystemRole role : roleMapper.selectByExample(roleExample)) {
            treeList.add(buildTree(role));
        }

        return treeList;
    }

    public List<RoleToResourceKey> getRoleToRes(SystemRole role, String resourceIds) {
        String[] resourceId = resourceIds.split(",");
        List<RoleToResourceKey> list = new ArrayList<>();
        for (int i = 0; i < resourceId.length; i++) {
            RoleToResourceKey toResourceKey = new RoleToResourceKey();
            toResourceKey.setRoleId(role.getId());
            toResourceKey.setResId(resourceId[i]);
            list.add(toResourceKey);
        }
        return list;
    }
}
