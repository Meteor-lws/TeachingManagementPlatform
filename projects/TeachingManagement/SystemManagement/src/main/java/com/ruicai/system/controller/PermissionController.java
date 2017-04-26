package com.ruicai.system.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.ruicai.system.po.system.ResourceCondition;
import com.ruicai.system.po.system.SystemResource;
import com.ruicai.system.service.PermissionService;
import com.ruicai.system.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by XuMing on 2017/4/4.
 */
@Controller
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/permission")
    public String index() {
        return "permissionEdit";
    }

    @ResponseBody
    @RequestMapping("/getPerByCondition")
    public String getPreByCondition(ResourceCondition condition){
       return JSON.toJSONString(permissionService.getPreByCondition(condition));
    }

    @RequestMapping(value = "/findPermission", method = RequestMethod.POST)
    @ResponseBody
    public String findPermission(){
        String json = JSON.toJSONString(permissionService.findResource());
        System.err.println(json);
        return json;
    }
}
