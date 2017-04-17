package com.ruicai.education.server.impl;

import com.ruicai.education.mapper.education.EducationClassMapper;
import com.ruicai.education.po.education.EducationClass;
import com.ruicai.education.server.ClassServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wy on 2017/4/16.
 */
@Service
public class ClassServerImpl implements ClassServer {

    @Autowired
    private EducationClassMapper educationClassMapper;

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

}
