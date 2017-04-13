package com.ruicai.education.controler;

import com.ruicai.education.po.education.EducationTeacher;
import com.ruicai.education.po.education.SystemDictionary;
import com.ruicai.education.po.education.TeacherCondition;
import com.ruicai.education.server.DictionaryServer;
import com.ruicai.education.server.TeacherServer;
import com.ruicai.education.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 教师管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
public class TeacherAction {

    @Autowired
    private DictionaryServer dictionaryServer;//注入字典服务
    @Autowired
    private TeacherServer teacherServer;//注入教师服务

    @RequestMapping("/teacher")
    public String index() {
        return "teacherEdit";
    }

    @RequestMapping("/teachingTypeList")
    public @ResponseBody
    List<SystemDictionary> teachingType() {
        List<SystemDictionary> teachingTypeList = dictionaryServer.selectDicByName("teaching-type");
        return teachingTypeList;
    }

    @RequestMapping("/teacherSelect")
    public List<EducationTeacher> selectTeacherByCondition(TeacherCondition condtition, PageBean<EducationTeacher> pageBean) {
        teacherServer.selectTeaByCondition(condtition, pageBean);
        return null;
    }


}
