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
        String[] resourceId = resourceIds.split(",");
        roleMapper.insert(role);
        List<RoleToResourceKey> list = new ArrayList<>();
        for (int i = 0; i < resourceId.length; i++) {
            RoleToResourceKey toResourceKey = new RoleToResourceKey();
            toResourceKey.setRoleId(role.getId());
            toResourceKey.setResId(resourceId[i]);
            list.add(toResourceKey);
        }
        int i = roleMapper.addResToRoleBatch(list);
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
}
