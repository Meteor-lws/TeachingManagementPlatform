package com.ruicai.education.controler;

import com.ruicai.education.mapper.education.SystemDictionaryMapper;
import com.ruicai.education.po.education.SystemDictionary;
import com.ruicai.education.server.DictionaryServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.List;

/**
 * 教师管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
public class TeacherAction {

    @Autowired
    private DictionaryServer dictionaryServer;


    @RequestMapping("/teacher")
    public String  index() {
        List<SystemDictionary> teachingType = dictionaryServer.selectDicByDesc("teaching-type");
        return "teacherEdit";
    }
}
