package com.ruicai.evaluation.service.impl;

import com.ruicai.evaluation.mapper.system.SystemDictionaryMapper;
import com.ruicai.evaluation.mapper.system.SystemDictionaryTypeMapper;
import com.ruicai.evaluation.po.system.SystemDictionary;
import com.ruicai.evaluation.po.system.SystemDictionaryExample;
import com.ruicai.evaluation.po.system.SystemDictionaryTypeExample;
import com.ruicai.evaluation.service.MessageReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 留言审核Service接口实现类
 *
 * Created by lws on 2017/4/21.
 */
@Service("MessageReviewService")
public class MessageReviewServiceImpl implements MessageReviewService {

    @Autowired
    private SystemDictionaryTypeMapper typeMapper;

    @Autowired
    private SystemDictionaryTypeExample typeExample;

    @Autowired
    private SystemDictionaryMapper dictionaryMapper;

    @Autowired
    private SystemDictionaryExample dictionaryExample;

    public List<SystemDictionary> getMessageStatuses() {
        typeExample.clear();
        typeExample.createCriteria().andDictionaryTypeNameEqualTo("message-status");
        dictionaryExample.clear();
        dictionaryExample.createCriteria().andDictionaryTypeIdEqualTo(typeMapper.selectByExample(typeExample).get(0).getId());
        dictionaryExample.setOrderByClause("DICTIONARY_SORT_NUMBER ASC");
        return dictionaryMapper.selectByExample(dictionaryExample);
    }
}
