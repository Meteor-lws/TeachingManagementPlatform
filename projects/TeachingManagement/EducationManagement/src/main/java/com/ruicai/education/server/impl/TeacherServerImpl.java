package com.ruicai.education.server.impl;

import com.ruicai.education.mapper.education.EducationTeacherMapper;
import com.ruicai.education.po.education.*;
import com.ruicai.education.server.DictionaryServer;
import com.ruicai.education.server.RoleService;
import com.ruicai.education.server.TeacherServer;
import com.ruicai.education.server.UserServer;
import com.ruicai.education.util.PageBean;
import com.ruicai.education.util.ReadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by XM on 2017/4/13.
 */
@Service
public class TeacherServerImpl implements TeacherServer {

    @Autowired
    private EducationTeacherMapper educationTeacherMapper;

    @Autowired
    private UserServer userServer; //注入用户服务
    @Autowired
    private DictionaryServer dictionaryServer;//注入字典服务
    @Autowired
    private RoleService roleService;

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
        if (null != teacher.getId()) {
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
        String phone = teacher.getTeacherPhone();
        user.setUserName(phone);//将手机号码设为用户名
        user.setUserNumber(UUID.randomUUID().toString().substring(0, 9));
        user.setUserStatus(enableDic.getId());
        user.setUserPwd("123456");
        user.setUserType(teacherDic.getId());
        String userId = userServer.insertUser(user);
        teacher.setUserId(userId);
        String[] role = teacher.getRole();
        for (int i = 0; i < role.length; i++) {
            Map<String, String> userToRole = new HashMap<>();
            userToRole.put("userId", user.getId());
            userToRole.put("roleId", role[i]);
            educationTeacherMapper.grantRole(userToRole);
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
        for (int i = 0; i < roles.length; i++) {
            //生成 用户——角色 中间表所对应的对象
            UserToRoleKey utr = new UserToRoleKey();
            utr.setRoleId(roles[i]);
            utr.setUserId(teacher.getUserId());
            roleService.addRole(utr);
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
        for (int i = 0; i < teacherIds.size(); i++) {
            educationTeacherMapper.deleteByPrimaryKey(teacherIds.get(i));
        }

        //删除用户角色表
        for (int i = 0; i < userIds.size(); i++) {
            roleService.deleteRoleByUserID(userIds.get(i));
        }

        //删除用户表信息
        for (int i = 0; i < userIds.size(); i++) {
            userServer.deleteByPrimaryKey(userIds.get(i));
        }


    }


}
