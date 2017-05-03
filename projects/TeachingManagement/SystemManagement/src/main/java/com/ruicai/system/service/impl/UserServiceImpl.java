package com.ruicai.system.service.impl;

import com.ruicai.system.mapper.system.SystemDictionaryMapper;
import com.ruicai.system.mapper.system.SystemUserMapper;
import com.ruicai.system.po.system.SystemDictionary;
import com.ruicai.system.po.system.SystemUser;
import com.ruicai.system.po.system.UserCondition;
import com.ruicai.system.service.DictionaryService;
import com.ruicai.system.service.UserService;
import com.ruicai.system.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wy on 2017/4/27.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SystemUserMapper systemUserMapper;
    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private SystemDictionaryMapper systemDictionaryMapper;


    @Override
    public List<SystemDictionary> getUserStatus() {
        return dictionaryService.selectDicByType("user-status");
    }

    @Override
    public List<SystemDictionary> getUserType() {
        return dictionaryService.selectDicByType("user-type");
    }

    @Override
    public PageBean<SystemUser> selectUserByCondition(UserCondition condition) {
        condition.setEndNum(condition.getPage() * condition.getRows() + 1);
        condition.setStartNum((condition.getPage() - 1) * condition.getRows());
        int total = selectUserByConditionCount(condition);
        PageBean<SystemUser> pageBean = new PageBean<>();
        List<SystemUser> list = systemUserMapper.selectUserByCondition(condition);
        pageBean.setTotal(total);
        pageBean.setRows(list);
        return pageBean;
    }

    @Override
    public int selectUserByConditionCount(UserCondition condition) {
        return systemUserMapper.selectUserByConditionCount(condition);
    }

    @Override
    public void updateUser(SystemUser user) {
        systemUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void initPass(List<String> idList) {
        for (int i = 0; i < idList.size(); i++) {
            SystemUser user = new SystemUser();
            user.setId(idList.get(i));
            user.setUserPwd("123456");
            systemUserMapper.updateByPrimaryKeySelective(user);
        }


    }
}
