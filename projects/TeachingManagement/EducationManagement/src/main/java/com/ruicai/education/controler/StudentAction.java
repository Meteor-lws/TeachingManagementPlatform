package com.ruicai.education.controler;

import com.alibaba.fastjson.JSON;
import com.ruicai.education.po.education.EducationStudent;
import com.ruicai.education.po.education.StudentCondition;
import com.ruicai.education.po.education.SystemDictionary;
import com.ruicai.education.po.education.SystemRole;
import com.ruicai.education.server.StudentServer;
import com.ruicai.education.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    /**
     * 条件查询
     *
     * @param condition 条件
     * @param pageBean  分页
     * @return
     */
    @RequestMapping("/studentSelect")
    public @ResponseBody
    PageBean<EducationStudent> getStudentSelect(StudentCondition condition, PageBean<EducationStudent> pageBean) {
        pageBean = studentServer.getStudentSelectByCondition(condition, pageBean);
        return pageBean;
    }

    /**
     * 添加或更新学生
     *
     * @param student 学生信息
     */
    @RequestMapping("/saveOrUpdateStudent")
    public @ResponseBody
    void saveOrUpdateStudent(EducationStudent student) {
        studentServer.saveOrUpdateStudent(student);
    }


    /**
     * 查询学生专业
     *
     * @return
     */
    @RequestMapping("/getStudentSpeciality")
    public @ResponseBody
    List<SystemDictionary> getStudentSpeciality() {
        return studentServer.getStudentSpeciality();

    }

    /**
     * 查询性别单选
     *
     * @return
     */
    @RequestMapping("/getStudentSex")
    public @ResponseBody
    List<SystemDictionary> getSexRedio() {
        return studentServer.getSexRedio();
    }

    /**
     * 获取保险单选按钮
     *
     * @return 保险单选列表
     */
    @RequestMapping("/getInsurance")
    public @ResponseBody
    List<SystemDictionary> getInsurance() {
        return studentServer.getInsurance();
    }

    /**
     * 上传学生图片
     *
     * @param request
     * @param response
     */
    @RequestMapping("/UpLoadStudentPic")
    public void UpLoadStudentPic(HttpServletRequest request, HttpServletResponse response) {
        String path = studentServer.UpLoadStudentPic(request);
        try {
            response.getWriter().write(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 学历
     *
     * @return
     */
    @RequestMapping("/getEducation")
    public @ResponseBody
    List<SystemDictionary> getEducation() {
        return studentServer.getEducation();
    }


    /**
     * 获取学生具有的角色
     *
     * @return 所有的学生角色列表
     */
    @RequestMapping("/getAllStudentRole")
    public @ResponseBody
    List<SystemRole> getAllStudentRole() {
        return studentServer.getAllStudentRole();
    }

    /**
     * 查询学生具有的角色
     *
     * @param userId
     * @return
     */
    @RequestMapping("/getStudentRole")
    public @ResponseBody
    List<SystemRole> getStudentRoleByUserId(String userId) {
        return studentServer.getStudentRole(userId);
    }


    @RequestMapping("/deleteStudent")
    public @ResponseBody
    void deleteStudentByBatch(String studentIds, String userIds) {

        List<String> tids = JSON.parseArray(studentIds, String.class);
        List<String> uids = JSON.parseArray(userIds, String.class);
        for (int i = 0; i < tids.size(); i++) {
            System.out.print(tids.get(i));
            System.out.print(uids.get(i));
        }
        studentServer.deleteByBatch(tids,uids);
    }



}
