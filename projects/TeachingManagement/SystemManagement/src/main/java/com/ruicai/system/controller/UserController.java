package com.ruicai.system.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.system.po.system.SystemDictionary;
import com.ruicai.system.po.system.SystemUser;
import com.ruicai.system.po.system.UserCondition;
import com.ruicai.system.service.UserService;
import com.ruicai.system.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 密码管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "UserManagement", method = RequestMethod.GET)
    public String UserManagement() {
        return "user";
    }

    @RequestMapping(value = "/getUserStatus")
    @ResponseBody
    public String getUserSatus() {
        List<SystemDictionary> statusList = userService.getUserStatus();
        return JSON.toJSONString(statusList);
    }

    @RequestMapping(value = "/getUserType")
    @ResponseBody
    public String getUserType() {
        List<SystemDictionary> typeList = userService.getUserType();
        return JSON.toJSONString(typeList);
    }

    @RequestMapping(value = "/selectUserByCondition")
    @ResponseBody
    public String selectUserByCondition(UserCondition condition) {
        PageBean<SystemUser> page = userService.selectUserByCondition(condition);
        return JSON.toJSONString(page);
    }

    @RequestMapping(value = "/saveOrUpdateUser")
    @ResponseBody
    public void saveOrUpdate(SystemUser user) {
        userService.updateUser(user);
    }

    @RequestMapping(value = "/initPass")
    @ResponseBody
    public void initPass(String ids) {
        List<String> idList = JSON.parseArray(ids, String.class);
        userService.initPass(idList);
    }
}
