package com.ruicai.evaluation.service;

import com.ruicai.evaluation.vo.EvaluationAnalysisView;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评价分析Service接口
 *
 * Created by lws on 2017/4/24.
 */
@Service
public interface EvaluationAnalysisService {
    List<EvaluationAnalysisView> GetAnalysisResults();
}
