package com.ruicai.evaluation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 留言审核控制器
 *
 * Created by lws on 2017/4/17.
 */
@SuppressWarnings("SameReturnValue")
@Controller
public class MessageReviewController {

    @RequestMapping(value = "MessageReview", method = RequestMethod.GET)
    public String MessageReview() {
        return "MessageReview";
    }
}
