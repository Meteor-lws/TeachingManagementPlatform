package com.ruicai.evaluation.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruicai.evaluation.mapper.education.EducationClassMapper;
import com.ruicai.evaluation.mapper.education.EducationStudentMapper;
import com.ruicai.evaluation.mapper.education.EducationTeacherMapper;
import com.ruicai.evaluation.mapper.evaluation.EvaluationDetailMapper;
import com.ruicai.evaluation.mapper.evaluation.EvaluationItemMapper;
import com.ruicai.evaluation.mapper.evaluation.EvaluationMapper;
import com.ruicai.evaluation.mapper.system.SystemUserMapper;
import com.ruicai.evaluation.po.education.*;
import com.ruicai.evaluation.po.education.EducationTeacherExample.Criteria;
import com.ruicai.evaluation.po.evaluation.*;
import com.ruicai.evaluation.po.system.SystemUserExample;
import com.ruicai.evaluation.service.EvaluationAnalysisService;
import com.ruicai.evaluation.vo.Datagrid;
import com.ruicai.evaluation.vo.EvaluationAnalysisView;
import com.ruicai.evaluation.vo.EvaluationDetailView;
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

    private final EvaluationItemMapper itemMapper;

    private final EvaluationItemExample itemExample;

    @Autowired
    public EvaluationAnalysisServiceImpl(EducationStudentExample studentExample, EducationClassMapper classMapper, EducationClassExample classExample, EducationTeacherMapper teacherMapper, EducationTeacherExample teacherExample, EducationStudentMapper studentMapper, SystemUserMapper userMapper, SystemUserExample userExample, EvaluationDetailExample detailExample, EvaluationMapper evaluationMapper, EvaluationExample evaluationExample, EvaluationDetailMapper detailMapper, EvaluationItemMapper itemMapper, EvaluationItemExample itemExample) {
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
        this.itemMapper = itemMapper;
        this.itemExample = itemExample;
    }

    public List<EvaluationAnalysisView> GetAnalysisResults(String className, String teacherName, String studentName) {
        classExample.clear();
        if (className != null) {
            classExample.createCriteria().andClassNameLike("%" + className + "%");
        }
        List<EducationClass> classes = classMapper.selectByExample(classExample);
        List<EvaluationAnalysisView> analysisViews = new ArrayList<>();
        for (EducationClass aClass : classes) {
            List<EvaluationAnalysisView> analysisViewList = buildAnalysisViews(aClass, teacherName, studentName);
            analysisViews.addAll(analysisViewList);
        }
        return analysisViews;
    }

    public Datagrid<EvaluationDetailView> GetAnalysisDetails(int page, int rows, String evaluationId, String evaluationTime) {
        detailExample.clear();
        detailExample.createCriteria().andEvaluationIdEqualTo(evaluationId);
        PageHelper.startPage(page, rows);
        List<EvaluationDetail> details = detailMapper.selectByExample(detailExample);
        Datagrid<EvaluationDetailView> datagrid = new Datagrid<>();
        datagrid.setTotal(new PageInfo<>(details).getTotal());
        List<EvaluationDetailView> detailViews = new ArrayList<>();
        for (EvaluationDetail detail : details) {
            detailViews.add(buildEvaluationDetailView(detail, evaluationTime));
        }
        datagrid.setRows(detailViews);
        return datagrid;
    }

    private EvaluationDetailView buildEvaluationDetailView(EvaluationDetail detail, String evaluationTime) {
        EvaluationDetailView detailView = new EvaluationDetailView();
        detailView.setId(detail.getId());
        detailView.setEvaluationId(detail.getEvaluationId());
        detailView.setItemId(detail.getItemId());
        detailView.setEvaluationTime(evaluationTime);
        detailView.setEvaluationScore(detail.getEvaluationScore());
        itemExample.clear();
        itemExample.createCriteria().andIdEqualTo(detail.getItemId());
        detailView.setEvaluationItem(itemMapper.selectByExample(itemExample).get(0).getItemContent());
        if (detailView.getEvaluationScore() < 5) {
            detailView.setSatisfaction("不满意");
        } else if (detailView.getEvaluationScore() < 7) {
            detailView.setSatisfaction("一般满意");
        } else if (detailView.getEvaluationScore() < 9) {
            detailView.setSatisfaction("比较满意");
        } else {
            detailView.setSatisfaction("非常满意");
        }
        return detailView;
    }

    private List<EvaluationAnalysisView> buildAnalysisViews(EducationClass educationClass, String teacherName, String studentName) {
        List<EvaluationAnalysisView> analysisViews = new ArrayList<>();
        teacherExample.clear();
        Criteria criteria = teacherExample.createCriteria().andIdEqualTo(educationClass.getHeadTeacherId());
        if (teacherName != null) {
            criteria.andTeacherNameLike("%" + teacherName + "%");
        }
        List<EducationTeacher> teachers = teacherMapper.selectByExample(teacherExample);
        EvaluationAnalysisView analysisView = buildAnalysisViewFromTeachers(teachers, educationClass, studentName);
        if (analysisView != null) {
            analysisViews.add(analysisView);
        }
        teacherExample.clear();
        Criteria criteria1 = teacherExample.createCriteria().andIdEqualTo(educationClass.getMainTeacherId());
        if (teacherName != null) {
            criteria1.andTeacherNameLike("%" + teacherName + "%");
        }
        teachers = teacherMapper.selectByExample(teacherExample);
        analysisView = buildAnalysisViewFromTeachers(teachers, educationClass, studentName);
        if (analysisView != null) {
            analysisViews.add(analysisView);
        }
        teacherExample.clear();
        Criteria criteria2 = teacherExample.createCriteria().andIdEqualTo(educationClass.getAssistantId());
        if (teacherName != null) {
            criteria2.andTeacherNameLike("%" + teacherName + "%");
        }
        teachers = teacherMapper.selectByExample(teacherExample);
        analysisView = buildAnalysisViewFromTeachers(teachers, educationClass, studentName);
        if (analysisView != null) {
            analysisViews.add(analysisView);
        }
        return analysisViews;
    }

    private EvaluationAnalysisView buildAnalysisViewFromTeachers(List<EducationTeacher> teachers, EducationClass educationClass, String studentName) {
        EvaluationAnalysisView analysisView = null;
        if (teachers.size() != 0) {
            EducationTeacher teacher = teachers.get(0);
            analysisView = buildAnalysisView(educationClass, teacher, studentName);
            if (analysisView.getChildren().size() == 0) {
                analysisView = null;
            }
        }
        return analysisView;
    }

    private EvaluationAnalysisView buildAnalysisView(EducationClass educationClass, EducationTeacher teacher, String studentName) {
        EvaluationAnalysisView analysisView = new EvaluationAnalysisView();
        userExample.clear();
        userExample.createCriteria().andIdEqualTo(teacher.getUserId());
        analysisView.setUserName(userMapper.selectByExample(userExample).get(0).getUserName());
        analysisView.setClassName(educationClass.getClassName());
        analysisView.setId(UUID.randomUUID().toString());
        List<EvaluationView> evaluationViews = buildAnalysisChildren(educationClass, teacher, studentName);
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

    private List<EvaluationView> buildAnalysisChildren(EducationClass educationClass, EducationTeacher teacher, String studentName) {
        List<EvaluationView> evaluationViews = new ArrayList<>();
        studentExample.clear();
        EducationStudentExample.Criteria criteria = studentExample.createCriteria().andClassIdEqualTo(educationClass.getId());
        if (studentName != null) {
            criteria.andStudentNameLike("%" + studentName + "%");
        }
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
