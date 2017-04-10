package com.ruicai.examination.serviceImpl;

import com.ruicai.examination.mapper.examination.ExaminationArrangementMapper;
import com.ruicai.examination.po.examination.ExaminationArrangement;
import com.ruicai.examination.service.ExaminationManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
