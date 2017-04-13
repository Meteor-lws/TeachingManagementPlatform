package com.ruicai.examination.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruicai.examination.mapper.examination.ExaminationArrangementMapper;
import com.ruicai.examination.po.education.EducationTeacher;
import com.ruicai.examination.po.examination.ExaminationArrangement;
import com.ruicai.examination.po.system.SystemDictionary;
import com.ruicai.examination.service.ExaminationManagementService;
import com.ruicai.examination.vo.examination.ClassTree;
import com.ruicai.examination.vo.examination.Management;
import com.ruicai.examination.vo.examination.ManagementDatagrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱高 on 2017/4/10.
 */
@Service("ExaminationManagementService")
public class ExaminationManagementServiceImpl implements ExaminationManagementService {
    @Autowired
    private ExaminationArrangementMapper examinationArrangementMapper;

    @Override
    public void addExaminationManagement(ExaminationArrangement examinationManagement) {
        System.out.println(examinationArrangementMapper + "........sad.................");
        examinationArrangementMapper.insert(examinationManagement);
    }

    /**
     * 分页查询考试安排
     *
     * @param managementDatagrid
     * @return
     */
    @Override
    public ManagementDatagrid findManagementDatagrid(ManagementDatagrid managementDatagrid) {
        PageHelper.startPage(managementDatagrid.getPage(), managementDatagrid.getRows());
        List<Management> arrangement = examinationArrangementMapper.findManagementDatagrid(managementDatagrid);
        PageInfo<Management> pageInfo = new PageInfo<>(arrangement);
        managementDatagrid.setTotal(pageInfo.getTotal());
        managementDatagrid.setList(arrangement);
        return managementDatagrid;
    }

    @Override
    public List<SystemDictionary> findDicTypeName(String dicTypeName) {
        List<SystemDictionary> list = examinationArrangementMapper.findDicTypeName(dicTypeName);
        return list;
    }

    public List<EducationTeacher> findTeacherName(){
        return examinationArrangementMapper.findTeacherName();
    }

    /**
     * 查询所有班级名字
     *
     * @return
     */
    @Override
    public List<ClassTree> findClassName() {
        List<SystemDictionary> list = examinationArrangementMapper.findDicTypeName("class-type");
        System.err.println(list);
        List<ClassTree> treeList = new ArrayList();
        for (SystemDictionary systemDictionary : list) {
            ClassTree classTree = new ClassTree();
            classTree.setId(systemDictionary.getId());
            classTree.setText(systemDictionary.getDictionaryName());
            classTree.setChildren(examinationArrangementMapper.findClassMessageByClassType(systemDictionary.getId()));
            treeList.add(classTree);
        }
        System.err.println(treeList);
        return treeList;
    }

    @Override
    public List<ClassTree> findClassMessageByClassType(String classType) {
        return examinationArrangementMapper.findClassMessageByClassType(classType);
    }

    @Override
    public void insert(ExaminationArrangement examinationArrangement) {
        int i = examinationArrangementMapper.insertSelective(examinationArrangement);
        System.err.println("i = " + i);
    }

}
