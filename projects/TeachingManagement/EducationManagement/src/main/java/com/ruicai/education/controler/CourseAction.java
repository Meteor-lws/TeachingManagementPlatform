package com.ruicai.education.controler;

import com.alibaba.fastjson.JSON;
import com.ruicai.education.po.education.EducationWork;
import com.ruicai.education.po.education.WorkCondition;
import com.ruicai.education.server.WorkServer;
import com.ruicai.education.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 课表管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
public class CourseAction {
    @Autowired
    private WorkServer workServer;

    @RequestMapping("/course")
    public String index() {
        return "courseEdit";
    }

    @RequestMapping("/selectCourseByCondition")
    public @ResponseBody
    PageBean<EducationWork> selectCourseByCondition(WorkCondition condition) {
        return workServer.selectCourseByCondition(condition);
    }

    @RequestMapping("/deleteCouByBatch")
    @ResponseBody
    public void deleteCouByBatch(String ids) {
        List<String> rids = JSON.parseArray(ids, String.class);
        workServer.deleteCouByBatch(rids);
    }


}
