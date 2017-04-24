package com.ruicai.education.server.impl;

import com.ruicai.education.mapper.education.EducationStudentMapper;
import com.ruicai.education.po.education.*;
import com.ruicai.education.server.*;
import com.ruicai.education.util.PageBean;
import com.ruicai.education.util.ReadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * Created by wy on 2017/4/19.
 */
@Service
public class StudentServiceImpl implements StudentServer {
    @Autowired
    private EducationStudentMapper educationStudentMapper;
    @Autowired
    private DictionaryServer dictionaryServer;
    @Autowired
    private UploadService uploadService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserServer userServer;



    /**
     * 分页条件查询学生列表
     *
     * @param condition 条件
     * @param pageBean  分页bean
     * @return 分页BEAN
     */
    @Override
    public PageBean<EducationStudent> getStudentSelectByCondition(StudentCondition condition, PageBean<EducationStudent> pageBean) {
        condition.setStartNum(condition.getRows() * (condition.getPage() - 1));
        condition.setEndNum(condition.getPage() * condition.getRows() + 1);
        List<EducationStudent> stuList = educationStudentMapper.selectStudentBycondition(condition);
        int total = educationStudentMapper.selectStudentByconditionCount(condition);
        pageBean.setTotal(total);
        pageBean.setRows(stuList);
        pageBean.setTotal(educationStudentMapper.selectStudentByconditionCount(condition));
        return pageBean;
    }

    /**
     * 添加或更新学生信息
     *
     * @param student 学生信息
     */
    @Override
    public void saveOrUpdateStudent(EducationStudent student) {
        if (student.getId() != null && !student.getId().equals("")) {
            updateStudent(student);
        } else {
            saveStudent(student);
        }

    }

    /**
     * 添加学生信息
     *
     * @param student 学生信息
     */
    @Override
    public void saveStudent(EducationStudent student) {
        //可用状态的字典对象
        SystemDictionary enableDic = dictionaryServer.selectDicByValue(ReadProperties.read("enable"));
        //学生的字典对象
        SystemDictionary studentDic = dictionaryServer.selectDicByValue(ReadProperties.read("student"));
        SystemUser user = new SystemUser();
        user.setUserName(student.getStudentPhone());
        user.setUserStatus(enableDic.getId());
        user.setUserType(studentDic.getId());
        user.setUserPwd("123456");
        user.setUserNumber(UUID.randomUUID().toString().substring(0, 9));
        //保存用户表
        userServer.insertUser(user);
        student.setUserId(user.getId());
        //学生角色
        String[] roles = student.getRole();
        for (int i = 0; i < roles.length; i++) {
            UserToRoleKey utr = new UserToRoleKey();
            utr.setUserId(student.getUserId());
            utr.setRoleId(roles[i]);
            //添加至用户角色表
            roleService.addRole(utr);
        }
        //保存学生表
        student.setStudentIdNumber(UUID.randomUUID().toString().substring(0, 9));
        educationStudentMapper.insert(student);
    }

    /**
     * 更新学生信息
     *
     * @param student
     */
    @Override
    public void updateStudent(EducationStudent student) {
        educationStudentMapper.updateByPrimaryKeySelective(student);
        String[] role = student.getRole();
        roleService.deleteRoleByUserID(student.getUserId());
        for (int i = 0; i < role.length; i++) {
            UserToRoleKey utr = new UserToRoleKey();
            utr.setUserId(student.getUserId());
            utr.setRoleId(role[i]);
            roleService.addRole(utr);
        }
    }

    @Override
    public List<SystemDictionary> getStudentSpeciality() {
        return dictionaryServer.selectDicByName(ReadProperties.read("studentSpeciality"));
    }

    @Override
    public List<SystemDictionary> getSexRedio() {
        return dictionaryServer.selectDicByName(ReadProperties.read("sex"));
    }

    @Override
    public List<SystemDictionary> getInsurance() {
        return dictionaryServer.selectDicByName(ReadProperties.read("insurance"));
    }

    @Override
    public String UpLoadStudentPic(HttpServletRequest request) {
        return uploadService.uploadPic(request);
    }

    @Override
    public List<SystemDictionary> getEducation() {
        return dictionaryServer.selectDicByName(ReadProperties.read("education"));
    }

    @Override
    public List<SystemRole> getAllStudentRole() {
        return roleService.getAllStudentRole();
    }

    @Override
    public List<SystemRole> getStudentRole(String userId) {
        return roleService.getStudentRole(userId);
    }

    /**
     * 批量删除学生
     *
     * @param studentIds
     */
    @Override
    public void deleteByBatch(List<String> studentIds, List<String> userIds) {
        //删除学生表
        for (int i = 0; i < studentIds.size(); i++) {
            educationStudentMapper.deleteByPrimaryKey(studentIds.get(i));
        }
        //删除用户表
        for (int i = 0; i < userIds.size(); i++) {
            userServer.deleteByPrimaryKey(userIds.get(i));
        }
        //删除角色表
        for (int i = 0; i < userIds.size(); i++) {
            roleService.deleteRoleByUserID(userIds.get(i));
        }


    }


}
