package com.ruicai.evaluation.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruicai.evaluation.mapper.evaluation.EvaluationMessageMapper;
import com.ruicai.evaluation.mapper.system.SystemDictionaryMapper;
import com.ruicai.evaluation.mapper.system.SystemDictionaryTypeMapper;
import com.ruicai.evaluation.mapper.system.SystemUserMapper;
import com.ruicai.evaluation.po.evaluation.EvaluationMessage;
import com.ruicai.evaluation.po.evaluation.EvaluationMessageExample;
import com.ruicai.evaluation.po.evaluation.EvaluationMessageExample.Criteria;
import com.ruicai.evaluation.po.system.*;
import com.ruicai.evaluation.service.MessageReviewService;
import com.ruicai.evaluation.vo.Datagrid;
import com.ruicai.evaluation.vo.EvaluationMessageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        dictionaryExample.setOrderByClause("DICTIONARY_SORT_NUMBER");
        return dictionaryMapper.selectByExample(dictionaryExample);
    }

    public Datagrid<EvaluationMessageView> getMessages(int page, int rows, EvaluationMessageView messageView) {

        Datagrid<EvaluationMessageView> result = new Datagrid<>();

        messageExample.clear();
        Criteria criteria = messageExample.createCriteria();

        if (messageView != null) {
            List<SystemUser> users;
            if (messageView.getFrom().length() > 0) {
                userExample.clear();
                userExample.createCriteria().andUserNameLike("%" + messageView.getFrom() + "%");
                users = userMapper.selectByExample(userExample);
                if (users.size() > 0) {
                    List<String> from = new ArrayList<>();
                    for (SystemUser user : users) {
                        from.add(user.getId());
                    }
                    criteria.andMessageFromIn(from);
                }
            }
            if (messageView.getTo().length() > 0) {
                userExample.clear();
                userExample.createCriteria().andUserNameLike("%" + messageView.getTo() + "%");
                users = userMapper.selectByExample(userExample);
                if (users.size() > 0) {
                    List<String> to = new ArrayList<>();
                    for (SystemUser user : users) {
                        to.add(user.getId());
                    }
                    criteria.andMessageToIn(to);
                }
            }
            if (messageView.getMessageStatus().length() > 0) {
                criteria.andMessageStatusEqualTo(messageView.getMessageStatus());
            }
            if (messageView.getMessageContent().length() > 0) {
                criteria.andMessageContentLike("%" + messageView.getMessageContent() + "%");
            }
            if (messageView.getMessageTime() != null) {
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(messageView.getMessageTime());
                calendar.add(Calendar.DATE, 1);
                Date date = calendar.getTime();
                criteria.andMessageTimeBetween(messageView.getMessageTime(), date);
            }
            System.err.println(messageView);
        }

        messageExample.setOrderByClause("MESSAGE_STATUS,");

        PageHelper.startPage(page, rows);
        List<EvaluationMessage> messages = messageMapper.selectByExample(messageExample);
        result.setTotal(new PageInfo<>(messages).getTotal());

        List<EvaluationMessageView> messageViews = new ArrayList<>();
        for (EvaluationMessage message : messages) {
            messageViews.add(buildMessageView(message));
        }
        result.setRows(messageViews);

        return result;
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
