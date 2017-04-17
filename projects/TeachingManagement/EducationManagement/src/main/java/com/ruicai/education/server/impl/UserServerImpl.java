package com.ruicai.education.server.impl;

import com.ruicai.education.mapper.education.SystemUserMapper;
import com.ruicai.education.po.education.SystemUser;
import com.ruicai.education.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wy on 2017/4/16.
 */
@Service
public class UserServerImpl implements UserServer {

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Override
    public String insertUser(SystemUser user) {
        systemUserMapper.insert(user);
        return user.getId();
    }
}
