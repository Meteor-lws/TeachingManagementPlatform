package com.ruicai.education.server;

import com.ruicai.education.po.education.EducationClass;

import java.util.List;

/**
 * Created by wy on 2017/4/16.
 */
public interface ClassServer {
    public List<EducationClass> getClassByType(String type);
}