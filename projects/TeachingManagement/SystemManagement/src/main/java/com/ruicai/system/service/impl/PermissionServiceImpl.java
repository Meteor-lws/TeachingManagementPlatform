package com.ruicai.system.service.impl;

import com.github.pagehelper.Page;
import com.ruicai.system.mapper.system.SystemResourceMapper;
import com.ruicai.system.po.system.ResourceCondition;
import com.ruicai.system.po.system.SystemResource;
import com.ruicai.system.po.system.SystemResourceExample;
import com.ruicai.system.service.PermissionService;
import com.ruicai.system.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wy on 2017/4/25.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private SystemResourceMapper systemResourceMapper;

    @Override
    public PageBean<SystemResource> getPreByCondition(ResourceCondition condition) {
        PageBean<SystemResource> page = new PageBean<>();
        condition.setStartNum((condition.getPage()-1)*condition.getRows());
        condition.setEndNum(condition.getPage()*condition.getRows()+1);
        List<SystemResource> resList = systemResourceMapper.selectPreByCondition(condition);
        page.setRows(resList);
        page.setTotal(systemResourceMapper.selectPreByConditionCount(condition));
        return page;
    }

    @Override
    public int getPreByConditionCount(ResourceCondition condition) {
        return systemResourceMapper.selectPreByConditionCount(condition);
    }

    @Override
    public List<SystemResource> findResource() {
        SystemResourceExample resourceExample = new SystemResourceExample();
        resourceExample.clear();
        return systemResourceMapper.selectByExample(resourceExample);
    }
}
