package com.ruicai.examination.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.examination.po.education.EducationTeacher;
import com.ruicai.examination.po.examination.ExaminationArrangement;
import com.ruicai.examination.po.system.SystemDictionary;
import com.ruicai.examination.service.ExaminationManagementService;
import com.ruicai.examination.vo.examination.ClassTree;
import com.ruicai.examination.vo.examination.ManagementDatagrid;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

/**
 * 朱高 2017/04/15
 */
@Controller
public class ExaminationManagementController {
    private final ExaminationManagementService examinationManagementService;

    @Autowired
    public ExaminationManagementController(ExaminationManagementService examinationManagementService) {
        this.examinationManagementService = examinationManagementService;
    }

    @RequestMapping(value = "/examination", method = RequestMethod.GET)
    public String toExaminationArrangement() {
        return "onlineExam/examinationArrangement";
    }

    @RequestMapping(value = "/datagrid", method = RequestMethod.POST)
    @ResponseBody
    public String findManagementDatagrid(ManagementDatagrid managementDatagrid) {
        managementDatagrid = examinationManagementService.findManagementDatagrid(managementDatagrid);
        String json = JSON.toJSONString(managementDatagrid.getList());
        json = "{\"total\":"+managementDatagrid.getTotal()+",\"rows\":" + json + "}";
        return json;
    }

    @RequestMapping(value = "/findDicTypeName", method = RequestMethod.POST)
    @ResponseBody
    public String findTestPhase(@Param(value = "dicTypeName") String dicTypeName){
        List<SystemDictionary> list = examinationManagementService.findDicTypeName(dicTypeName);
        return JSON.toJSONString(list);
    }
    @RequestMapping(value = "/findTeacherName", method = RequestMethod.POST)
    @ResponseBody
    public String findTeacherName() {
        List<EducationTeacher> list = examinationManagementService.findTeacherName();
        return JSON.toJSONString(list);
    }

    @RequestMapping(value = "/className", method = RequestMethod.POST)
    @ResponseBody
    public String findClassName(){
        List<ClassTree> list = examinationManagementService.findClassName();
        return JSON.toJSONString(list);
    }

    @RequestMapping(value = "/addExaminationArrangementMessage", method = RequestMethod.POST)
    @ResponseBody
    public String addClassMessage(ExaminationArrangement examinationArrangement){
        examinationArrangement.setPaperId(UUID.randomUUID().toString().replace("-",""));
        examinationManagementService.insert(examinationArrangement);
        return "考试安排添加成功";
    }

    @RequestMapping(value = "/updateExaminationArrangementMessage", method = RequestMethod.POST)
    @ResponseBody
    public String updateExaminationArrangementMessage(ExaminationArrangement examinationArrangement){
        System.err.println(examinationArrangement);
        examinationManagementService.updateExaminationArrangementMessage(examinationArrangement);
        return "考试安排更新成功";
    }

    @RequestMapping(value = "/removeExaminationArrangementMessage", method = RequestMethod.DELETE)
    @ResponseBody
    public String removeExaminationArrangementMessage(@Param(value = "ids")String ids){
        examinationManagementService.deleteExaminationArrangement(ids);
        return "删除考试安排成功";
    }
}
