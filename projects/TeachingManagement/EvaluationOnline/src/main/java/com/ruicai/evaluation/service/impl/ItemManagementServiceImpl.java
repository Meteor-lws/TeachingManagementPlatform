package com.ruicai.evaluation.service.impl;

import com.ruicai.evaluation.mapper.system.SystemDictionaryMapper;
import com.ruicai.evaluation.mapper.system.SystemDictionaryTypeMapper;
import com.ruicai.evaluation.po.system.SystemDictionary;
import com.ruicai.evaluation.po.system.SystemDictionaryExample;
import com.ruicai.evaluation.po.system.SystemDictionaryTypeExample;
import com.ruicai.evaluation.service.ItemManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评价项管理Service接口实现类
 *
 * Created by lws on 2017/4/17.
 */
@Service("ItemManagementService")
public class ItemManagementServiceImpl implements ItemManagementService {
    private final SystemDictionaryTypeMapper typeMapper;
    private final SystemDictionaryMapper dictionaryMapper;
    private final SystemDictionaryTypeExample typeExample;
    private final SystemDictionaryExample dictionaryExample;

    @Autowired
    public ItemManagementServiceImpl(SystemDictionaryTypeMapper typeMapper, SystemDictionaryMapper dictionaryMapper, SystemDictionaryTypeExample typeExample, SystemDictionaryExample dictionaryExample) {
        this.typeMapper = typeMapper;
        this.dictionaryMapper = dictionaryMapper;
        this.typeExample = typeExample;
        this.dictionaryExample = dictionaryExample;
    }

    public List<SystemDictionary> getEvaluationItemTypes() {
        typeExample.clear();
        typeExample.createCriteria().andDictionaryTypeNameEqualTo("evaluation-type");
        String typeId = typeMapper.selectByExample(typeExample).get(0).getId();
        dictionaryExample.clear();
        dictionaryExample.createCriteria().andDictionaryTypeIdEqualTo(typeId);
        dictionaryExample.setOrderByClause("DICTIONARY_SORT_NUMBER ASC");
        return dictionaryMapper.selectByExample(dictionaryExample);
    }
}
