package com.ruicai.examination.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.examination.service.ProblemManagementService;
import com.ruicai.examination.vo.question.Question;
import com.ruicai.examination.vo.question.QuestionDatagrid;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 朱高 on 2017/4/18.
 */
@Controller
public class ProblemManagementController {

    private final ProblemManagementService problemService;

    @Autowired
    public ProblemManagementController(ProblemManagementService problemService) {
        this.problemService = problemService;
    }

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public String goToProManagement() {
        return "onlineExam/problemManagement";
    }

    @RequestMapping(value = "/selectQuestion")
    @ResponseBody
    public String selectQuestion(int page, int rows, Question question) {
        System.err.println(question);
        QuestionDatagrid questionDatagrid = problemService.selectQuestion(page, rows, question);
        return JSON.toJSONString(questionDatagrid);
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("myfiles") MultipartFile fileField,
                             @RequestParam(value = "formFieldId", required = false, defaultValue = "pic_url") String formFieldId,
                             HttpServletRequest request) throws IOException {
        System.err.println(formFieldId);
        System.err.println("sss name = " + fileField.getOriginalFilename());
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String curDateDir = dateFormat.format(now);// 当天日期,用于当天的目录名称
        System.err.println(curDateDir);
        // 图片地址
        StringBuffer picUrl = new StringBuffer(request.getSession().getServletContext().getRealPath("/"));

        // 格式:  /picture/日期/文件名
        picUrl = picUrl.append("picture\\").append(curDateDir).append("\\");
        System.err.println(picUrl);
        // 可行后缀
        final String[] allowedExt = new String[]{"gif", "GIF",
                "jpg", "JPG", "swf", "SWF", "PNG", "png", "FLV",
                "flv", "FLA", "fla", "jpeg", "doc", "docx", "PDF", "pdf", "xls", "xlsx"};

        String fileName = "";
        try {

            // 得到文件的扩展名(无扩展名时将得到全名)
            String t_ext = fileField.getOriginalFilename().substring(
                    fileField.getOriginalFilename().lastIndexOf(".") + 1);
            System.out.println("文件后缀为:" + t_ext);
            // 判断后缀 是否 被允许
            boolean allowFlag = false;
            for (String string : allowedExt) {
                if (string.equals(t_ext.toLowerCase())) {
                    allowFlag = true;
                    break;
                }
            }
            System.out.println("aa");
            // 后缀不符
            if (false == allowFlag) {

                String message = "请上传以下类型的文件:";
                for (String string : allowedExt) {
                    message += " *." + string;
                }
                message += "\n当前上传的文件格式为: " + t_ext;
                Map<String, String> map = new HashMap<>();
                //map.put("formFieldId", formFieldId);
                map.put("message", message);
                return JSON.toJSONString(map);
            }
            // 文件 1000K 大小限制
            if (fileField.getSize() > 1000 * 1024) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("formFieldId", formFieldId);
                map.put("message", "上传文件大小不被允许!");
                return "";//JSONObject.valueToString(map);
            }
            System.out.println("cc");
            // 文件名
            String name = fileField.getOriginalFilename();
            System.err.println("name = " + name);
            // 处理文件名
            fileName = "" + (int) (Math.random() * 1000) + "_" + name;
            //fileName = FileUtil.dealName(name);
            System.err.println("fileName = " + fileName);
            // 先上传到 web
            FileUtils.copyInputStreamToFile(fileField.getInputStream(), new File(picUrl.toString(), fileName));

            System.out.println(picUrl.toString() + fileName);

            // 生成图片地址
            picUrl.append(fileName);


        } catch (Exception e) {

            e.printStackTrace();
        }
        System.out.println("ff");

        Map<String, String> map = new HashMap<String, String>();
        //map.put("formFieldId", formFieldId);
        map.put("fileUrl", "/picture/" + curDateDir + "/" + fileName);
        map.put("message", "上传成功!");
        return JSON.toJSONString(map);
    }
}
