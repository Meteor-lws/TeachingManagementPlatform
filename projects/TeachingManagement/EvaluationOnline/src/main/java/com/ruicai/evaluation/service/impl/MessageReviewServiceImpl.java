package com.ruicai.evaluation.service.impl;

import com.ruicai.evaluation.mapper.evaluation.EvaluationMessageMapper;
import com.ruicai.evaluation.mapper.system.SystemDictionaryMapper;
import com.ruicai.evaluation.mapper.system.SystemDictionaryTypeMapper;
import com.ruicai.evaluation.mapper.system.SystemUserMapper;
import com.ruicai.evaluation.po.evaluation.EvaluationMessage;
import com.ruicai.evaluation.po.evaluation.EvaluationMessageExample;
import com.ruicai.evaluation.po.system.SystemDictionary;
import com.ruicai.evaluation.po.system.SystemDictionaryExample;
import com.ruicai.evaluation.po.system.SystemDictionaryTypeExample;
import com.ruicai.evaluation.po.system.SystemUserExample;
import com.ruicai.evaluation.service.MessageReviewService;
import com.ruicai.evaluation.vo.Datagrid;
import com.ruicai.evaluation.vo.EvaluationMessageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 留言审核Service接口实现类
 *
 * Created by lws on 2017/4/21.
 */
@Service("MessageReviewService")
public class MessageReviewServiceImpl implements MessageReviewService {

    private final SystemDictionaryTypeMapper typeMapper;

    private final SystemDictionaryTypeExample typeExample;

    private final SystemDictionaryMapper dictionaryMapper;

    private final SystemDictionaryExample dictionaryExample;

    private final SystemUserMapper userMapper;

    private final SystemUserExample userExample;

    private final EvaluationMessageMapper messageMapper;

    private final EvaluationMessageExample messageExample;

    @Autowired
    public MessageReviewServiceImpl(SystemDictionaryTypeMapper typeMapper, SystemDictionaryTypeExample typeExample, SystemDictionaryMapper dictionaryMapper, SystemDictionaryExample dictionaryExample, SystemUserMapper userMapper, SystemUserExample userExample, EvaluationMessageMapper messageMapper, EvaluationMessageExample messageExample) {
        this.typeMapper = typeMapper;
        this.typeExample = typeExample;
        this.dictionaryMapper = dictionaryMapper;
        this.dictionaryExample = dictionaryExample;
        this.userMapper = userMapper;
        this.userExample = userExample;
        this.messageMapper = messageMapper;
        this.messageExample = messageExample;
    }

    public List<SystemDictionary> getMessageStatuses() {
        typeExample.clear();
        typeExample.createCriteria().andDictionaryTypeNameEqualTo("message-status");
        dictionaryExample.clear();
        dictionaryExample.createCriteria().andDictionaryTypeIdEqualTo(typeMapper.selectByExample(typeExample).get(0).getId());
        dictionaryExample.setOrderByClause("DICTIONARY_SORT_NUMBER ASC");
        return dictionaryMapper.selectByExample(dictionaryExample);
    }

    public Datagrid<EvaluationMessageView> getMessages() {
        messageExample.clear();
        List<EvaluationMessage> messages = messageMapper.selectByExample(messageExample);
        List<EvaluationMessageView> messageViews = new ArrayList<>();
        for (EvaluationMessage message : messages) {
            messageViews.add(buildMessageView(message));
        }
        Datagrid<EvaluationMessageView> datagrid = new Datagrid<>();
        datagrid.setTotal(messageViews.size());
        datagrid.setRows(messageViews);
        return datagrid;
    }

    private EvaluationMessageView buildMessageView(EvaluationMessage message) {
        EvaluationMessageView messageView = new EvaluationMessageView();
        messageView.setId(message.getId());
        messageView.setParentId(message.getParentId());
        messageView.setMessageFrom(message.getMessageFrom());
        messageView.setMessageTo(message.getMessageTo());
        messageView.setMessageStatus(message.getMessageStatus());
        messageView.setMessageTime(message.getMessageTime());
        messageView.setMessageContent(message.getMessageContent());
        userExample.clear();
        userExample.createCriteria().andIdEqualTo(messageView.getMessageFrom());
        messageView.setFrom(userMapper.selectByExample(userExample).get(0).getUserName());
        userExample.clear();
        userExample.createCriteria().andIdEqualTo(messageView.getMessageTo());
        messageView.setTo(userMapper.selectByExample(userExample).get(0).getUserName());
        dictionaryExample.clear();
        dictionaryExample.createCriteria().andIdEqualTo(messageView.getMessageStatus());
        messageView.setStatus(dictionaryMapper.selectByExample(dictionaryExample).get(0).getDictionaryName());
        return messageView;
    }
}
