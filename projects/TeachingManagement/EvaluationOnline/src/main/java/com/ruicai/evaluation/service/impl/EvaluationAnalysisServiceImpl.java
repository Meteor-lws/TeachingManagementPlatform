package com.ruicai.evaluation.service.impl;

import com.ruicai.evaluation.mapper.education.EducationClassMapper;
import com.ruicai.evaluation.mapper.education.EducationStudentMapper;
import com.ruicai.evaluation.mapper.education.EducationTeacherMapper;
import com.ruicai.evaluation.mapper.evaluation.EvaluationDetailMapper;
import com.ruicai.evaluation.mapper.evaluation.EvaluationMapper;
import com.ruicai.evaluation.mapper.system.SystemUserMapper;
import com.ruicai.evaluation.po.education.*;
import com.ruicai.evaluation.po.evaluation.Evaluation;
import com.ruicai.evaluation.po.evaluation.EvaluationDetailExample;
import com.ruicai.evaluation.po.evaluation.EvaluationExample;
import com.ruicai.evaluation.po.system.SystemUserExample;
import com.ruicai.evaluation.service.EvaluationAnalysisService;
import com.ruicai.evaluation.vo.EvaluationAnalysisView;
import com.ruicai.evaluation.vo.EvaluationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 评价分析Service接口实现类
 *
 * Created by lws on 2017/4/24.
 */
@Service("EvaluationAnalysisService")
public class EvaluationAnalysisServiceImpl implements EvaluationAnalysisService {

    private final EducationClassMapper classMapper;

    private final EducationClassExample classExample;

    private final EducationTeacherMapper teacherMapper;

    private final EducationTeacherExample teacherExample;

    private final EducationStudentMapper studentMapper;

    private final EducationStudentExample studentExample;

    private final SystemUserMapper userMapper;

    private final SystemUserExample userExample;

    private final EvaluationMapper evaluationMapper;

    private final EvaluationExample evaluationExample;

    private final EvaluationDetailMapper detailMapper;

    private final EvaluationDetailExample detailExample;

    @Autowired
    public EvaluationAnalysisServiceImpl(EducationStudentExample studentExample, EducationClassMapper classMapper, EducationClassExample classExample, EducationTeacherMapper teacherMapper, EducationTeacherExample teacherExample, EducationStudentMapper studentMapper, SystemUserMapper userMapper, SystemUserExample userExample, EvaluationDetailExample detailExample, EvaluationMapper evaluationMapper, EvaluationExample evaluationExample, EvaluationDetailMapper detailMapper) {
        this.studentExample = studentExample;
        this.classMapper = classMapper;
        this.classExample = classExample;
        this.teacherMapper = teacherMapper;
        this.teacherExample = teacherExample;
        this.studentMapper = studentMapper;
        this.userMapper = userMapper;
        this.userExample = userExample;
        this.detailExample = detailExample;
        this.evaluationMapper = evaluationMapper;
        this.evaluationExample = evaluationExample;
        this.detailMapper = detailMapper;
    }

    public List<EvaluationAnalysisView> GetAnalysisResults() {
        classExample.clear();
        List<EducationClass> classes = classMapper.selectByExample(classExample);
        List<EvaluationAnalysisView> analysisViews = new ArrayList<>();
        for (EducationClass aClass : classes) {
            List<EvaluationAnalysisView> analysisViewList = buildAnalysisViews(aClass);
            analysisViews.addAll(analysisViewList);
        }
        return analysisViews;
    }

    private List<EvaluationAnalysisView> buildAnalysisViews(EducationClass educationClass) {
        List<EvaluationAnalysisView> analysisViews = new ArrayList<>();
        teacherExample.clear();
        teacherExample.createCriteria().andIdEqualTo(educationClass.getHeadTeacherId());
        EducationTeacher headTeacher = teacherMapper.selectByExample(teacherExample).get(0);
        EvaluationAnalysisView headTeacherView = buildAnalysisView(educationClass, headTeacher);
        if (headTeacherView.getChildren().size() != 0) {
            analysisViews.add(headTeacherView);
        }
        teacherExample.clear();
        teacherExample.createCriteria().andIdEqualTo(educationClass.getMainTeacherId());
        EducationTeacher mainTeacher = teacherMapper.selectByExample(teacherExample).get(0);
        EvaluationAnalysisView mainTeacherView = buildAnalysisView(educationClass, mainTeacher);
        if (mainTeacherView.getChildren().size() != 0) {
            analysisViews.add(mainTeacherView);
        }
        teacherExample.clear();
        teacherExample.createCriteria().andIdEqualTo(educationClass.getAssistantId());
        EducationTeacher assistant = teacherMapper.selectByExample(teacherExample).get(0);
        EvaluationAnalysisView assistantView = buildAnalysisView(educationClass, assistant);
        if (assistantView.getChildren().size() != 0) {
            analysisViews.add(assistantView);
        }
        return analysisViews;
    }

    private EvaluationAnalysisView buildAnalysisView(EducationClass educationClass, EducationTeacher teacher) {
        EvaluationAnalysisView analysisView = new EvaluationAnalysisView();
        userExample.clear();
        userExample.createCriteria().andIdEqualTo(teacher.getUserId());
        analysisView.setUserName(userMapper.selectByExample(userExample).get(0).getUserName());
        analysisView.setClassName(educationClass.getClassName());
        analysisView.setId(UUID.randomUUID().toString().replace("-", ""));
        List<EvaluationView> evaluationViews = buildAnalysisChildren(educationClass, teacher);
        analysisView.setChildren(evaluationViews);
        if (evaluationViews.size() != 0) {
            analysisView.setEvaluationScore((short) 0);
            for (EvaluationView evaluationView : evaluationViews) {
                analysisView.setEvaluationScore((short) (evaluationView.getEvaluationScore() + analysisView.getEvaluationScore()));
            }
            analysisView.setAverageScore(analysisView.getEvaluationScore() / (double) evaluationViews.size());
        }
        return analysisView;
    }

    private List<EvaluationView> buildAnalysisChildren(EducationClass educationClass, EducationTeacher teacher) {
        List<EvaluationView> evaluationViews = new ArrayList<>();
        studentExample.clear();
        studentExample.createCriteria().andClassIdEqualTo(educationClass.getId());
        List<EducationStudent> students = studentMapper.selectByExample(studentExample);
        if (students.size() != 0) {
            List<String> studentIds = new ArrayList<>();
            for (EducationStudent student : students) {
                studentIds.add(student.getId());
            }
            evaluationExample.clear();
            evaluationExample.createCriteria().andStudentIdIn(studentIds).andTeacherIdEqualTo(teacher.getId());
            List<Evaluation> evaluations = evaluationMapper.selectByExample(evaluationExample);
            for (Evaluation evaluation : evaluations) {
                evaluationViews.add(buildEvaluationView(educationClass, evaluation));
            }
        }
        return evaluationViews;
    }

    private EvaluationView buildEvaluationView(EducationClass aClass, Evaluation evaluation) {
        EvaluationView view = new EvaluationView();
        view.setId(evaluation.getId());
        view.setStudentId(evaluation.getStudentId());
        view.setTeacherId(evaluation.getTeacherId());
        view.setEvaluationTime(evaluation.getEvaluationTime());
        view.setEvaluationScore(evaluation.getEvaluationScore());
        view.setEvaluationFeedback(evaluation.getEvaluationFeedback());
        studentExample.clear();
        studentExample.createCriteria().andIdEqualTo(evaluation.getStudentId());
        userExample.clear();
        userExample.createCriteria().andIdEqualTo(studentMapper.selectByExample(studentExample).get(0).getUserId());
        view.setUserName(userMapper.selectByExample(userExample).get(0).getUserName());
        view.setClassName(aClass.getClassName());
        detailExample.clear();
        detailExample.createCriteria().andEvaluationIdEqualTo(evaluation.getId());
        double size = (double) detailMapper.selectByExample(detailExample).size();
        if (size != 0) {
            view.setAverageScore(view.getEvaluationScore() / size);
        }
        return view;
    }
}
