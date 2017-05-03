package com.ruicai.system.service;

import com.ruicai.system.po.system.ResourceCondition;
import com.ruicai.system.po.system.SystemDictionary;
import com.ruicai.system.po.system.SystemResource;
import com.ruicai.system.util.PageBean;

import java.util.List;

/**
 * Created by wy on 2017/4/25.
 */
public interface PermissionService {
    /**
     * 条件分页查询
     * @param condition
     * @return
     */
    PageBean<SystemResource> getPreByCondition(ResourceCondition condition);

    /**
     * 查询满足条件的数量
     * @param condition
     * @return
     */
    int getPreByConditionCount(ResourceCondition condition);

    List<SystemResource> findResource();

    List<SystemDictionary> getAllResourcetype();

    List<SystemDictionary> getResourceEnable();

    List<SystemDictionary> getResourceVisible();

    void saveOrUpdateResource(SystemResource resource);

    void updateResource(SystemResource resource);

    void saveResource(SystemResource resource);
}
