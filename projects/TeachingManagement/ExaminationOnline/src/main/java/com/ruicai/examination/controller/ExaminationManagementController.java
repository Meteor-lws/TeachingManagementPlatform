package com.ruicai.examination.controller;

import com.ruicai.examination.po.examination.ExaminationArrangement;
import com.ruicai.examination.service.ExaminationManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 朱高 on 2017/4/10.
 */
@Controller
public class ExaminationManagementController {
    @Autowired
    private ExaminationManagementService examinationManagementService;

    @RequestMapping(value = "/mybatistest", method = RequestMethod.GET)
    public void mybatistest() {
        ExaminationArrangement examinationArrangement = new ExaminationArrangement();
        System.out.println(examinationManagementService + "...............fds..............");
        examinationManagementService.addExaminationManagement(examinationArrangement);
    }
}
