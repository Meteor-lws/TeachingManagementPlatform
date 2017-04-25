package com.ruicai.education.controler;

import com.alibaba.fastjson.JSON;
import com.ruicai.education.po.education.ClassCondition;
import com.ruicai.education.po.education.EducationClass;
import com.ruicai.education.po.education.SystemDictionary;
import com.ruicai.education.server.ClassServer;
import com.ruicai.education.server.DictionaryServer;
import com.ruicai.education.util.PageBean;
import com.ruicai.education.util.TreeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 班级管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
public class ClassAction {

    @Autowired
    private ClassServer classServer;
    @Autowired
    private DictionaryServer dictionaryServer;
    @RequestMapping("/class")
    public String index() {
        return "classEdit";
    }

    @RequestMapping("/getClass")
    public @ResponseBody
    List<TreeBean> getClassName() {

        List<TreeBean> info = new ArrayList<>();
        //查出所有的班级类别所对应的数据字典值
        info = classServer.getClassTree(info);
        return info;
    }

    @RequestMapping("/selectClassByCondition")
    public @ResponseBody
    PageBean<EducationClass> selectClassByCondition(ClassCondition condition) {
        return classServer.selectByCondition(condition);

    }

    /**
     * 获取班级类型
     *
     * @return
     */
    @RequestMapping("/getClassType")
    public @ResponseBody
    List<SystemDictionary> getClassType() {
        return classServer.getClassType();
    }

    @RequestMapping("/saveOrUpdateClass")
    public @ResponseBody
    void saveOrUpdate(EducationClass educationClass) {
        classServer.saveOrUpdate(educationClass);
    }

    @RequestMapping("/deleteClassByBatch")
    public @ResponseBody
    void deleteClassByBatch(String ids) {
        List<String> idlist = JSON.parseArray(ids, String.class);
        classServer.deleteClassByBatch(idlist);
    }

}
