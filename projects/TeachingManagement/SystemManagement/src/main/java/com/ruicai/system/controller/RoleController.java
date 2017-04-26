package com.ruicai.system.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.system.po.system.SystemRole;
import com.ruicai.system.service.PermissionService;
import com.ruicai.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by XuMing on 2017/4/4.
 */
@Controller
public class RoleController {
    @Autowired
    private final RoleService roleService;
    @Autowired
    private final PermissionService permissionService;
    public RoleController(RoleService roleService, PermissionService permissionService) {
        this.roleService = roleService;
        this.permissionService = permissionService;
    }

    @RequestMapping("/role")
    public String index() {

        System.err.println("role");
        return "role";
    }

    @RequestMapping("/addRole")
    @ResponseBody
    public String addRole(SystemRole role) {

        return "";
    }

    @RequestMapping("/findRole")
    @ResponseBody
    public String findRole() {
        String json = JSON.toJSONString(roleService.findRoleTree());
        System.err.println(json);
        return json;
    }

}
