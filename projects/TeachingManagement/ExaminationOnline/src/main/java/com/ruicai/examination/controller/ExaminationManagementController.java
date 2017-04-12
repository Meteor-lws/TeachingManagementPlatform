package com.ruicai.examination.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.examination.service.ExaminationManagementService;
import com.ruicai.examination.vo.examination.ManagementDatagrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 朱高 on 2017/4/10.
 */
@Controller
public class ExaminationManagementController {
    @Autowired
    private ExaminationManagementService examinationManagementService;

    @RequestMapping(value = "/examination", method = RequestMethod.GET)
    public String toExaminationArrangement() {
        return "onlineExam/examinationArrangement";
    }

    @RequestMapping(value = "/datagrid", method = RequestMethod.POST)
    public String mybatistest(ManagementDatagrid managementDatagrid) {
        System.err.println(managementDatagrid);
        managementDatagrid = examinationManagementService.findManagementDatagrid(managementDatagrid);
        String json = JSON.toJSONString(managementDatagrid.getList());
        json = "{\"total\":120,\"rows\":" + json + "}";
        System.err.println("json = " + json);

        return json;
    }

    @RequestMapping(value = "/findAllManagement", method = RequestMethod.POST)
    @ResponseBody
    public String findAllManagement(ManagementDatagrid managementDatagrid) {

        return "";
    }
}
