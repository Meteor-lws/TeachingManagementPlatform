package com.ruicai.education.server;

import com.ruicai.education.po.education.SystemUser;

/**
 * Created by wy on 2017/4/16.
 */
public interface UserServer {
    /**
     * 插入用户
     *
     * @param user 用户
     * @return 插入用户的id
     */
    public String insertUser(SystemUser user);

}
