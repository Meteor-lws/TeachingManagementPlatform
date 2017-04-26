package com.ruicai.system.controller;

import com.alibaba.fastjson.JSON;
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

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping("/role")
    public String index() {

        System.err.println("role");
        return "role";
    }

    @RequestMapping("/addRole")
    @ResponseBody
    public String addRole() {

        return "";
    }

    @RequestMapping("/findPermission")
    @ResponseBody
    public String findPermission() {
        /*Tree tree = new Tree();
        tree.setChildren(roleService.findRoleTree());
        tree.setText("所有角色");
        tree.setId("root");*/
        String json = JSON.toJSONString(roleService.findRoleTree());
        System.err.println(json);
        return json;
    }
}
