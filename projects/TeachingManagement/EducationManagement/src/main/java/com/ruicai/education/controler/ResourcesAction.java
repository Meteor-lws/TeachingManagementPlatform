package com.ruicai.education.controler;

import com.alibaba.fastjson.JSON;
import com.ruicai.education.po.education.EducationTeacher;
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
 * 课件管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
public class ResourcesAction {

    @Autowired
    private WorkServer workServer;

    /**
     *
     * @return
     */
    @RequestMapping("/resources")
    public String index() {
        return "resourcesEdit";
    }

    /**
     * 获取系统所有教师
     *
     * @return 教师列表
     */
    @RequestMapping("/getUploader")
    public @ResponseBody
    List<EducationTeacher> getUploder() {
        List<EducationTeacher> teacherList = workServer.selectAllTeacher();
        return teacherList;
    }

    @RequestMapping("/getResByCondition")
    public @ResponseBody
    PageBean<EducationWork> getResourceByCondition(WorkCondition condition, PageBean<EducationWork> pageBean) {
        return workServer.getResByCondition(condition, pageBean);
    }

    @RequestMapping("/deleteResByBatch")
    public @ResponseBody
    void deleteResByBatch(String ids) {
        List<String> rids = JSON.parseArray(ids, String.class);
        workServer.deleteResByBatch(rids);
    }

    @RequestMapping("/downloadByBatch")
    public void downLoad(String paths) {

    }

}
