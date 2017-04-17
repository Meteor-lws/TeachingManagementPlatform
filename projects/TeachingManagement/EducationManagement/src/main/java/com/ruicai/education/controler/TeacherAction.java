package com.ruicai.education.controler;

import com.ruicai.education.po.education.EducationTeacher;
import com.ruicai.education.po.education.SystemDictionary;
import com.ruicai.education.po.education.SystemRole;
import com.ruicai.education.po.education.TeacherCondition;
import com.ruicai.education.server.DictionaryServer;
import com.ruicai.education.server.RoleService;
import com.ruicai.education.server.TeacherServer;
import com.ruicai.education.util.PageBean;
import com.ruicai.education.util.ReadProperties;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
     * @param respon
     * @throws FileUploadException
     */
    @RequestMapping("/getUpLoadPath")
    public void getUpLoadPath(HttpServletRequest request, HttpServletResponse respon) throws FileUploadException {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        String path;
        boolean flag = resolver.isMultipart(request);
        if (resolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> fileNames = multiRequest.getFileNames();
            while (fileNames.hasNext()) {
                MultipartFile file = multiRequest.getFile(fileNames.next());
                if (file != null) {
                    String FileName = file.getOriginalFilename();
                    if (!FileName.trim().equals("")) {
                        try {
                            String suffix = FileName.substring(FileName.lastIndexOf("."));
                            String upLoadName = UUID.randomUUID().toString();
                            file.transferTo(new File("D:\\Tomcat\\Upload\\apache-tomcat-7.0.75\\webapps\\Upload\\" + upLoadName + suffix));
                            path = upLoadName + suffix;
                            respon.getWriter().write(path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

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


}
