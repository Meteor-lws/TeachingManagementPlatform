package com.ruicai.system.service;

import com.ruicai.system.po.system.SystemDictionary;
import com.ruicai.system.po.system.SystemUser;
import com.ruicai.system.po.system.UserCondition;
import com.ruicai.system.util.PageBean;

import java.util.List;

/**
 * Created by wy on 2017/4/27.
 */
public interface UserService {
    List<SystemDictionary> getUserStatus();

    List<SystemDictionary> getUserType();

    PageBean<SystemUser> selectUserByCondition(UserCondition condition);

    int selectUserByConditionCount(UserCondition condition);


    void updateUser(SystemUser user);

    void initPass(List<String> idList);
}
