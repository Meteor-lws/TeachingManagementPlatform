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
 * 周报管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
public class WeeklyAction {

    @Autowired
    private WorkServer workServer;

    @RequestMapping("/weekly")
    public String index() {
        return "weeklyEdit";
    }

    @RequestMapping("/deleteWeeByBatch")
    public @ResponseBody
    void deleteWeeByBatch(String ids) {
        List<String> idList = JSON.parseArray(ids, String.class);
        workServer.deleteWeeByBatch(idList);
    }

    @RequestMapping("selectWeeByCondition")
    public @ResponseBody
    PageBean<EducationWork> selectWeeByCondition(WorkCondition condition) {
        return workServer.selectWeeByCondition(condition);
    }



}
