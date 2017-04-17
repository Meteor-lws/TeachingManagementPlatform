package com.ruicai.education.server.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruicai.education.mapper.education.EducationTeacherMapper;
import com.ruicai.education.mapper.education.SystemDictionaryMapper;
import com.ruicai.education.po.education.EducationTeacher;
import com.ruicai.education.po.education.SystemDictionary;
import com.ruicai.education.po.education.SystemUser;
import com.ruicai.education.po.education.TeacherCondition;
import com.ruicai.education.server.DictionaryServer;
import com.ruicai.education.server.TeacherServer;
import com.ruicai.education.server.UserServer;
import com.ruicai.education.util.PageBean;
import com.ruicai.education.util.ReadProperties;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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


    @Override
    public int selectTeaByConditionCount(TeacherCondition condition) {
        return educationTeacherMapper.selectTeaByConditionCount(condition);
    }

    @Override
    public PageBean<EducationTeacher> selectTeaByCondition(TeacherCondition condition, PageBean<EducationTeacher> pageBean) {
        int total = selectTeaByConditionCount(condition);
        char[] page = condition.getPage();
        try {
            pageBean.setPage(Integer.parseInt(page[0] + ""));
        } catch (Exception e) {
            pageBean.setPage(1);
        }
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
        educationTeacherMapper.insert(teacher);
    }

    @Override
    public void updateTea(EducationTeacher teacher) {
        educationTeacherMapper.updateByPrimaryKeySelective(teacher);
    }

    /**
     * 查询所有教师
     *
     * @return 教师列表
     */
    @Override
    public List<EducationTeacher> selectAll() {

        return educationTeacherMapper.selectAll();
    }

}
