package com.ruicai.education.controler;

import com.ruicai.education.po.education.EducationStudent;
import com.ruicai.education.po.education.StudentCondition;
import com.ruicai.education.po.education.SystemDictionary;
import com.ruicai.education.server.StudentServer;
import com.ruicai.education.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 学生管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
public class StudentAction {

    @Autowired
    private StudentServer studentServer;

    @RequestMapping("/student")
    public String index() {
        return "studentEdit";
    }

    @RequestMapping("/studentSelect")
    public PageBean<EducationStudent> getStudentSelect(StudentCondition condition, PageBean<EducationStudent> pageBean) {
        pageBean = studentServer.getStudentSelectByCondition(condition, pageBean);
        return null;
    }

    /**
     * 添加或更新学生
     *
     * @param student 学生信息
     */
    @RequestMapping("/saveOrUpdateStudent")
    public void saveOrUpdateStudent(EducationStudent student) {
        studentServer.saveOrUpdateStudent(student);

    }


    /**
     * 查询学生状态
     *
     * @return
     */
    @RequestMapping("/getStudentStatu")
    public @ResponseBody
    List<SystemDictionary> getStudentStatu() {
        return studentServer.getStudentStatu();

    }



}
