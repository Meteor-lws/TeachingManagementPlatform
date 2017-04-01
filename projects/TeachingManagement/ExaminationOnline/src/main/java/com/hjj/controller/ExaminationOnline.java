package com.hjj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 朱高 on 2017/4/1.
 */
@Controller
public class ExaminationOnline {

    @RequestMapping(value = "/examination", method = RequestMethod.GET)
    public String toExaminationArrangement() {
        return "onlineExam/examinationArrangement";
    }
}
