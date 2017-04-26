package com.ruicai.system.service;

import com.github.pagehelper.Page;
import com.ruicai.system.po.system.ResourceCondition;
import com.ruicai.system.po.system.SystemResource;
import com.ruicai.system.util.PageBean;

import java.util.List;
import java.util.concurrent.locks.Condition;

/**
 * Created by wy on 2017/4/25.
 */
public interface PermissionService {
    /**
     * 条件分页查询
     * @param condition
     * @return
     */
    public PageBean<SystemResource> getPreByCondition(ResourceCondition condition);

    /**
     * 查询满足条件的数量
     * @param condition
     * @return
     */
    public int getPreByConditionCount(ResourceCondition condition );

    List<SystemResource> findResource();
}
