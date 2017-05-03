package com.ruicai.education.controler;

import com.alibaba.fastjson.JSON;
import com.ruicai.education.po.education.EducationTeacher;
import com.ruicai.education.po.education.EducationWork;
import com.ruicai.education.po.education.WorkCondition;
import com.ruicai.education.server.WorkServer;
import com.ruicai.education.util.PageBean;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 课件管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
public class ResourcesAction {

    @Autowired
    private WorkServer workServer;

    /**
     *
     * @return
     */
    @RequestMapping("/resources")
    public String index() {
        return "resourcesEdit";
    }

    /**
     * 获取系统所有教师
     *
     * @return 教师列表
     */
    @RequestMapping("/getUploader")
    public @ResponseBody
    List<EducationTeacher> getUploder() {
        List<EducationTeacher> teacherList = workServer.selectAllTeacher();
        return teacherList;
    }

    @RequestMapping("/getResByCondition")
    public @ResponseBody
    PageBean<EducationWork> getResourceByCondition(WorkCondition condition, PageBean<EducationWork> pageBean) {
        return workServer.getResByCondition(condition, pageBean);
    }

    @RequestMapping("/deleteResByBatch")
    public @ResponseBody
    void deleteResByBatch(String ids) {
        List<String> rids = JSON.parseArray(ids, String.class);
        workServer.deleteResByBatch(rids);
    }

    @RequestMapping("/downloadByBatch")
    public void download(HttpServletResponse res) throws IOException {
        OutputStream os = res.getOutputStream();
        try {
            res.reset();
            res.setHeader("Content-Disposition", "attachment; filename=dict.txt");
            res.setContentType("application/octet-stream; charset=utf-8");
            os.write(FileUtils.readFileToByteArray(new File("D:\\Tomcat\\Upload\\apache-tomcat-7.0.75\\webapps\\Upload\\jQuery EasyUI 1.4.5 版 API 中文版 (Made By Richie696).chm")));
            os.flush();
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }
}
