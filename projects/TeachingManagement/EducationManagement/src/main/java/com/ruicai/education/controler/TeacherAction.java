package com.ruicai.education.controler;

import com.alibaba.fastjson.JSON;
import com.ruicai.education.po.education.EducationTeacher;
import com.ruicai.education.po.education.SystemDictionary;
import com.ruicai.education.po.education.SystemRole;
import com.ruicai.education.po.education.TeacherCondition;
import com.ruicai.education.server.DictionaryServer;
import com.ruicai.education.server.RoleService;
import com.ruicai.education.server.TeacherServer;
import com.ruicai.education.server.UploadService;
import com.ruicai.education.util.PageBean;
import com.ruicai.education.util.ReadProperties;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 教师管理
 * Created by XuMing on 2017/3/31.
 */
@Controller
public class TeacherAction {

    @Autowired
    private DictionaryServer dictionaryServer;//注入字典服务
    @Autowired
    private TeacherServer teacherServer;//注入教师服务
    @Autowired
    private RoleService roleService;//注入角色服务
    @Autowired
    private UploadService uploadService;//注入上传服务

    /**
     * 教师管理页面
     *
     * @return
     */
    @RequestMapping("/teacher")
    public String index(Model model) {
        return "teacherEdit";
    }

    @RequestMapping("/getSexRadion")
    public @ResponseBody
    List<SystemDictionary> getSexRadion() {
        List<SystemDictionary> sexList = dictionaryServer.selectDicByName(ReadProperties.read("sex"));
        return sexList;

    }


    /**
     * teacherType职教类型下拉框数据
     *
     * @return
     */
    @RequestMapping("/teachingTypeList")
    public @ResponseBody
    List<SystemDictionary> teachingType() {
        List<SystemDictionary> teachingTypeList = dictionaryServer.selectDicByName(ReadProperties.read("teachingType"));
        return teachingTypeList;
    }


    /**
     * 教师查询
     *
     * @param condtition 条件
     * @param pageBean   分页BEAN
     * @return 符合条件数据
     */
    @RequestMapping("/teacherSelect")
    public @ResponseBody
    PageBean<EducationTeacher> selectTeacherByCondition(TeacherCondition condtition, PageBean<EducationTeacher> pageBean) {
        PageBean<EducationTeacher> teacherList = teacherServer.selectTeaByCondition(condtition, pageBean);
        return teacherList;
    }

    /**
     * 教师图片上传
     *
     * @param request
     * @param response
     * @throws FileUploadException
     */
    @RequestMapping("/getUpLoadPath")
    public void getUpLoadPath(HttpServletRequest request, HttpServletResponse response) {
        String path = teacherServer.uploadPic(request);
        try {
            response.getWriter().write(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 教师专业
     *
     * @return
     */
    @RequestMapping("/getTeacherSpeciality")
    public @ResponseBody
    List<SystemDictionary> getTeacherSpeciality() {
        List<SystemDictionary> specList = dictionaryServer.selectDicByName(ReadProperties.read("teacherSpeciality"));
        return specList;
    }


    /**
     * 保存或修改
     *
     * @param response
     * @param teacher
     */
    @RequestMapping("/saveOrUpdate")
    public void saveOrUpdate(HttpServletResponse response, EducationTeacher teacher) {
        teacherServer.saveOrUpdate(teacher);
    }

    /**
     * 获取所有teacher的角色
     *
     * @return teacher角色列表
     */
    @RequestMapping("/getTeacherRole")
    public @ResponseBody
    List<SystemRole> getRoles() {
        List<SystemRole> roleList = roleService.selectAllTeacherRole();
        return roleList;
    }

    /**
     * 获取教师角色信息
     *
     * @return 教师角色信息
     */
    @RequestMapping("/getTeacherInfo")
    public @ResponseBody
    List<SystemRole> getTeacherInfo(String userId) {
        return roleService.getTeacherRole(userId);
    }

    /**
     * 批量删除教师
     *
     * @param teacherIds 教师的ID集合
     * @param userIds    教师用户ID集合
     */
    @RequestMapping("/deleteTeacher")
    public @ResponseBody
    String deleteTeacherByBatch(String teacherIds, String userIds) {
        List<String> tids = JSON.parseArray(teacherIds, String.class);
        List<String> uids = JSON.parseArray(userIds, String.class);
        teacherServer.deleteTeacherByBatch(tids, uids);
        return "success";

    }


    /**
     * 获得所有主讲教师
     *
     * @return
     */
    @RequestMapping("/getAllMainTeacher")
    public @ResponseBody
    List<EducationTeacher> getAllMainTeacher() {
        return teacherServer.getAllMainTeacher();
    }

    /**
     * 获得所有班主任
     *
     * @return
     */
    @RequestMapping("/getAllHeadTeacher")
    public @ResponseBody
    List<EducationTeacher> getAllHeadTeacher() {
        return teacherServer.getAllHeadTeacher();
    }

    /**
     * 获得所有助教
     *
     * @return
     */
    @RequestMapping("/getAllAssiTeacher")
    public @ResponseBody
    List<EducationTeacher> getAllAssiTeacher() {
        return teacherServer.getAllAssiTeacher();
    }


}