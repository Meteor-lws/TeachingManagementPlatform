package com.ruicai.examination.serviceImpl;

import com.ruicai.examination.mapper.examination.ExaminationArrangementMapper;
import com.ruicai.examination.po.examination.ExaminationArrangement;
import com.ruicai.examination.service.ExaminationManagementService;
import com.ruicai.examination.vo.examination.Management;
import com.ruicai.examination.vo.examination.ManagementDatagrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<Management> arrangement = examinationArrangementMapper.findManagementDatagrid(managementDatagrid);
        managementDatagrid.setList(arrangement);
        return managementDatagrid;
    }

    @Override
    public List<String> findDicTypeName(String dicTypeName) {
        examinationArrangementMapper.findDicTypeName(dicTypeName);
        return null;
    }

}
