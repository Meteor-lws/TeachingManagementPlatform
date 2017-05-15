package com.ruicai.education.server.impl;

import com.ruicai.education.mapper.education.EducationTeacherMapper;
import com.ruicai.education.po.education.*;
import com.ruicai.education.server.*;
import com.ruicai.education.util.PageBean;
import com.ruicai.education.util.ReadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XM on 2017/4/13.
 */
@Service
public class TeacherServerImpl implements TeacherServer {

    private final EducationTeacherMapper educationTeacherMapper;

    private final UserServer userServer; //注入用户服务
    private final DictionaryServer dictionaryServer;//注入字典服务
    private final RoleService roleService;
    private final UploadService uploadService;

    @Autowired
    public TeacherServerImpl(EducationTeacherMapper educationTeacherMapper, UserServer userServer, DictionaryServer dictionaryServer, RoleService roleService, UploadService uploadService) {
        this.educationTeacherMapper = educationTeacherMapper;
        this.userServer = userServer;
        this.dictionaryServer = dictionaryServer;
        this.roleService = roleService;
        this.uploadService = uploadService;
    }

    @Override
    public int selectTeaByConditionCount(TeacherCondition condition) {
        return educationTeacherMapper.selectTeaByConditionCount(condition);
    }

    @Override
    public PageBean<EducationTeacher> selectTeaByCondition(TeacherCondition condition, PageBean<EducationTeacher> pageBean) {
        int total = selectTeaByConditionCount(condition);
        Integer page = condition.getPage();
        if (page == null) {
            page = 1;
        }
        condition.setStartNum((page - 1) * condition.getRows());
        condition.setEndNum((page * condition.getRows()) + 1);
        pageBean.setRowNums(condition.getRows());
        List<EducationTeacher> teacherList = educationTeacherMapper.selectTeaByCondition(condition);
        pageBean.setRows(teacherList);
        pageBean.setTotal(total);
        return pageBean;
    }

    @Override
    public void saveOrUpdate(EducationTeacher teacher) {
        if (null != teacher.getId() && !teacher.getUserId().equals("")) {
            updateTea(teacher);
        } else {
            saveTea(teacher);
        }
    }

    @Override
    public void saveTea(EducationTeacher teacher) {
        //查询教师对应的字典
        SystemDictionary teacherDic = dictionaryServer.selectDicByValue(ReadProperties.read("teacher"));
        //查询可用对应的字典
        SystemDictionary enableDic = dictionaryServer.selectDicByValue(ReadProperties.read("enable"));
        SystemUser user = new SystemUser();
        user.setUserName(teacher.getTeacherNumber());
        user.setUserStatus(enableDic.getId());
        user.setUserPwd("123456");
        user.setUserType(teacherDic.getId());
        String userId = userServer.insertUser(user);
        teacher.setUserId(userId);
        String[] role = teacher.getRole();
        if (role != null) {
            for (String aRole : role) {
                Map<String, String> userToRole = new HashMap<>();
                userToRole.put("userId", user.getId());
                userToRole.put("roleId", aRole);
                educationTeacherMapper.grantRole(userToRole);
            }
        }
        educationTeacherMapper.insert(teacher);
    }

    @Override
    public void updateTea(EducationTeacher teacher) {
        educationTeacherMapper.updateByPrimaryKeySelective(teacher);
        //删除用户所有的角色
        roleService.deleteRoleByUserID(teacher.getUserId());
        String[] roles = teacher.getRole();
        //遍历添加
        if (roles != null) {
            for (String role : roles) {
                //生成 用户——角色 中间表所对应的对象
                UserToRoleKey utr = new UserToRoleKey();
                utr.setRoleId(role);
                utr.setUserId(teacher.getUserId());
                roleService.addRole(utr);
            }
        }

    }

    /**
     * 查询所有教师
     * @return 教师列表
     */
    @Override
    public List<EducationTeacher> selectAll() {
        return educationTeacherMapper.selectAll();
    }

    /**
     * 批量删除教师
     *
     * @param teacherIds 教师id集合
     * @param userIds    用户id集合
     */
    @Override
    public void deleteTeacherByBatch(List<String> teacherIds, List<String> userIds) {

        //删除教师表信息
        for (String teacherId : teacherIds) {
            educationTeacherMapper.deleteByPrimaryKey(teacherId);
        }

        //删除用户角色表
        for (String userId : userIds) {
            roleService.deleteRoleByUserID(userId);
        }

        //删除用户表信息
        for (String userId : userIds) {
            userServer.deleteByPrimaryKey(userId);
        }


    }

    @Override
    public String uploadPic(HttpServletRequest request) {
        return uploadService.uploadPic(request);
    }

    @Override
    public List<EducationTeacher> getAllMainTeacher() {
        return educationTeacherMapper.selectAllTeacherByType(ReadProperties.read("mainTeacher"));
    }

    @Override
    public List<EducationTeacher> getAllHeadTeacher() {
        return educationTeacherMapper.selectAllTeacherByType(ReadProperties.read("headTeacher"));
    }

    @Override
    public List<EducationTeacher> getAllAssiTeacher() {
        return educationTeacherMapper.selectAllTeacherByType(ReadProperties.read("assistantTeacher"));
    }


}
