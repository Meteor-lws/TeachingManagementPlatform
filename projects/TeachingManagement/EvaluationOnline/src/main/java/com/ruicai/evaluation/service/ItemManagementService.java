package com.ruicai.evaluation.service;

import com.ruicai.evaluation.po.evaluation.EvaluationItem;
import com.ruicai.evaluation.po.system.SystemDictionary;
import com.ruicai.evaluation.vo.Datagrid;
import com.ruicai.evaluation.vo.EvaluationItemView;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评价项管理Service接口
 *
 * Created by lws on 2017/4/17.
 */
@Service
public interface ItemManagementService {
    List<SystemDictionary> getEvaluationItemTypes();

    Datagrid<EvaluationItemView> getEvaluationItems(int page, int rows, String typeId, String enable, String itemContent);

    void editEvaluationItem(EvaluationItem item);

    void deleteEvaluationItems(List<String> ids);
}
