package com.ruicai.evaluation.service;

import com.ruicai.evaluation.po.system.SystemDictionary;
import com.ruicai.evaluation.vo.Datagrid;
import com.ruicai.evaluation.vo.EvaluationMessageView;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 留言审核Service接口
 *
 * Created by lws on 2017/4/21.
 */
@Service
public interface MessageReviewService {
    List<SystemDictionary> getMessageStatuses();

    Datagrid<EvaluationMessageView> getMessages();
}
