package com.ruicai.education.controler;

import com.ruicai.education.po.education.EducationClass;
import com.ruicai.education.po.education.EducationTeacher;
import com.ruicai.education.po.education.EducationWork;
import com.ruicai.education.po.education.SystemDictionary;
import com.ruicai.education.server.ClassServer;
import com.ruicai.education.server.DictionaryServer;
import com.ruicai.education.server.TeacherServer;
import com.ruicai.education.util.TreeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 课件管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
public class ResourcesAction {

    @Autowired
    private DictionaryServer dictionaryServer;

    @Autowired
    private ClassServer classServer;

    @Autowired
    private TeacherServer teacherServer;

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/resources")
    public String index() {
        return "resourcesEdit";
    }

    /**
     * 获取班级下拉框数据
     *
     * @return
     */
    @RequestMapping("/getClass")
    public @ResponseBody
    List<TreeBean> getClassName() {
        List<TreeBean> info = new ArrayList<>();
        //查出所有的班级类别所对应的数据字典值
        List<SystemDictionary> dictionaryList = dictionaryServer.selectDicByName("class-type");
        for (SystemDictionary dic : dictionaryList) {
            TreeBean treeBean = new TreeBean();
            treeBean.setId(dic.getId());
            treeBean.setText(dic.getDictionaryName());
            List<TreeBean.Child> chilren = new ArrayList<>();
            //根据班级类别查出的班级列表
            List<EducationClass> classInfo = classServer.getClassByType(dic.getId());
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

    /**
     * 获取系统所有教师
     *
     * @return 教师列表
     */
    @RequestMapping("/getUploader")
    public @ResponseBody
    List<EducationTeacher> getUploder() {
        List<EducationTeacher> teacherList = teacherServer.selectAll();
        return teacherList;
    }



}
