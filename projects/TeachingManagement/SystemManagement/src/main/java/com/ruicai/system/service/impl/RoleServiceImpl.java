package com.ruicai.system.service.impl;

import com.ruicai.system.mapper.system.SystemRoleMapper;
import com.ruicai.system.po.system.SystemRole;
import com.ruicai.system.po.system.SystemRoleExample;
import com.ruicai.system.service.RoleService;
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

    private Tree tree;
    private List<Tree> children;

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
