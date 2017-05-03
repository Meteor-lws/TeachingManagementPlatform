package com.ruicai.system.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.system.po.system.ResourceCondition;
import com.ruicai.system.po.system.SystemDictionary;
import com.ruicai.system.po.system.SystemResource;
import com.ruicai.system.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping(value = "/getAllResourceType", method = RequestMethod.POST)
    @ResponseBody
    public String getAllResourceType() {
        List<SystemDictionary> list = permissionService.getAllResourcetype();
        return JSON.toJSONString(list);
    }

    @RequestMapping(value = "/getResourceEnable", method = RequestMethod.POST)
    @ResponseBody
    public String getResourceEnable() {
        List<SystemDictionary> list = permissionService.getResourceEnable();
        return JSON.toJSONString(list);
    }

    @RequestMapping(value = "/getResourceVisible", method = RequestMethod.POST)
    @ResponseBody
    public String getResourceVisible() {
        List<SystemDictionary> list = permissionService.getResourceVisible();
        return JSON.toJSONString(list);
    }

    @RequestMapping(value = "/saveOrUpdateResource", method = RequestMethod.POST)
    @ResponseBody
    public void saveOrUpdateResource(SystemResource resource) {
        permissionService.saveOrUpdateResource(resource);
    }


}
