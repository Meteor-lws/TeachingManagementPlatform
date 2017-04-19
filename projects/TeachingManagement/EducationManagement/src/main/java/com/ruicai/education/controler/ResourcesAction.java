package com.ruicai.education.controler;

import com.ruicai.education.po.education.EducationTeacher;
import com.ruicai.education.server.ClassServer;
import com.ruicai.education.server.DictionaryServer;
import com.ruicai.education.server.TeacherServer;
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
    private DictionaryServer dictionaryServer;

    @Autowired
    private ClassServer classServer;

    @Autowired
    private TeacherServer teacherServer;

    /**
     * 首页
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
        List<EducationTeacher> teacherList = teacherServer.selectAll();
        return teacherList;
    }



}
