package com.ruicai.education.server.impl;

import com.ruicai.education.mapper.education.EducationClassMapper;
import com.ruicai.education.po.education.ClassCondition;
import com.ruicai.education.po.education.EducationClass;
import com.ruicai.education.po.education.SystemDictionary;
import com.ruicai.education.server.ClassServer;
import com.ruicai.education.server.DictionaryServer;
import com.ruicai.education.util.PageBean;
import com.ruicai.education.util.ReadProperties;
import com.ruicai.education.util.TreeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wy on 2017/4/16.
 */
@Service
public class ClassServerImpl implements ClassServer {

    @Autowired
    private EducationClassMapper educationClassMapper;

    @Autowired
    private DictionaryServer dictionaryServer;

    /**
     * 根据班级的类别来查询班级
     *
     * @param type 班级类型
     * @return 符合条件的班级
     */
    @Override
    public List<EducationClass> getClassByType(String type) {
        return educationClassMapper.selectClassByType(type);
    }

    @Override
    public List<TreeBean> getClassTree(List<TreeBean> info) {
        List<SystemDictionary> dictionaryList = dictionaryServer.selectDicByName("class-type");
        for (SystemDictionary dic : dictionaryList) {
            TreeBean treeBean = new TreeBean();
            treeBean.setId(dic.getId());
            treeBean.setText(dic.getDictionaryName());
            List<TreeBean.Child> chilren = new ArrayList<>();
            //根据班级类别查出的班级列表
            List<EducationClass> classInfo = getClassByType(dic.getId());
            for (EducationClass eduClass : classInfo) {
                TreeBean.Child child = new TreeBean().new Child();
                child.setId(eduClass.getId());
                child.setText(eduClass.getClassName());
                chilren.add(child);
            }
            treeBean.setChildren(chilren);
            info.add(treeBean);
        }
        return info;
    }

    @Override
    public PageBean<EducationClass> selectByCondition(ClassCondition condition) {
        condition.setStartNum((condition.getPage() - 1) * condition.getRows());
        condition.setEndNum(condition.getPage() * condition.getRows() + 1);
        PageBean<EducationClass> pageBean = new PageBean<>();
        List<EducationClass> list = educationClassMapper.selectByCondition(condition);
        int total = educationClassMapper.selectByConditionCount(condition);
        pageBean.setTotal(total);
        pageBean.setRows(list);
        return pageBean;
    }

    @Override
    public int selectByConditionCount(ClassCondition condition) {
        return educationClassMapper.selectByConditionCount(condition);
    }

    @Override
    public List<SystemDictionary> getClassType() {
        return dictionaryServer.selectDicByName(ReadProperties.read("classType"));
    }

    @Override
    public void saveOrUpdate(EducationClass educationClass) {
        if (educationClass.getId() != null && !educationClass.getId().equals("")) {
            educationClassMapper.updateByPrimaryKeySelective(educationClass);
        } else {
            educationClassMapper.insert(educationClass);
        }
    }

    @Override
    public void deleteClassByBatch(List<String> idlist) {

        for (int i = 0; i < idlist.size(); i++) {
            educationClassMapper.deleteByPrimaryKey(idlist.get(i));
        }
    }

}
