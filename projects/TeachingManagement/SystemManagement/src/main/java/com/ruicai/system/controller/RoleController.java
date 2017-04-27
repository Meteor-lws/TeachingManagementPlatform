package com.ruicai.system.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.system.po.system.RoleToResourceKey;
import com.ruicai.system.po.system.SystemRole;
import com.ruicai.system.service.PermissionService;
import com.ruicai.system.service.RoleService;
import com.ruicai.system.vo.RoleShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public String addRole(SystemRole role, String resourceId) {
        System.err.println(resourceId);
        System.err.println(role);
        roleService.addRole(role, resourceId);
        return "添加角色成功";
    }

    @RequestMapping(value = "/updateRole", method = RequestMethod.POST)
    @ResponseBody
    public String updateRole(SystemRole role, String resourceId) {
        System.err.println(role);
        System.err.println(resourceId);
        roleService.updateRole(role, resourceId);
        return "修改角色信息成功";
    }
    @RequestMapping("/findRole")
    @ResponseBody
    public String findRole() {
        String json = JSON.toJSONString(roleService.findRoleTree());
        System.err.println(json);
        return json;
    }

    @RequestMapping(value = "/findRoleDetails", method = RequestMethod.POST)
    @ResponseBody
    public String findRoleDetails(RoleShow roleShow) {
        System.err.println(roleShow);
        String json = JSON.toJSONString(roleService.findRoleDetails(roleShow));
        System.err.println(json);
        return json;
    }

    @RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
    @ResponseBody
    public String deleteRoleById(String id) {
        roleService.deleteRoleById(id);
        return "删除角色成功";
    }

    @RequestMapping(value = "/deleteResource", method = RequestMethod.POST)
    @ResponseBody
    public String deleteResourceByIds(RoleToResourceKey roleToResourceKey) {
        System.err.println(roleToResourceKey);
        roleService.deleteResourceByIds(roleToResourceKey);
        return "删除角色资源成功";
    }

    @RequestMapping(value = "/findRoleById", method = RequestMethod.POST)
    @ResponseBody
    public String findRoleById(String id) {

        return "查询角色成功";
    }
}
