package com.ruicai.evaluation.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruicai.evaluation.mapper.evaluation.EvaluationItemMapper;
import com.ruicai.evaluation.mapper.system.SystemDictionaryMapper;
import com.ruicai.evaluation.mapper.system.SystemDictionaryTypeMapper;
import com.ruicai.evaluation.po.evaluation.EvaluationItem;
import com.ruicai.evaluation.po.evaluation.EvaluationItemExample;
import com.ruicai.evaluation.po.evaluation.EvaluationItemExample.Criteria;
import com.ruicai.evaluation.po.system.SystemDictionary;
import com.ruicai.evaluation.po.system.SystemDictionaryExample;
import com.ruicai.evaluation.po.system.SystemDictionaryTypeExample;
import com.ruicai.evaluation.service.ItemManagementService;
import com.ruicai.evaluation.vo.Datagrid;
import com.ruicai.evaluation.vo.EvaluationItemView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 评价项管理Service接口实现类
 *
 * Created by lws on 2017/4/17.
 */
@Service("ItemManagementService")
public class ItemManagementServiceImpl implements ItemManagementService {
    private final EvaluationItemMapper itemMapper;
    private final SystemDictionaryTypeMapper typeMapper;
    private final SystemDictionaryMapper dictionaryMapper;
    private final EvaluationItemExample itemExample;
    private final SystemDictionaryTypeExample typeExample;
    private final SystemDictionaryExample dictionaryExample;

    @Autowired
    public ItemManagementServiceImpl(SystemDictionaryTypeMapper typeMapper, SystemDictionaryMapper dictionaryMapper, SystemDictionaryTypeExample typeExample, SystemDictionaryExample dictionaryExample, EvaluationItemMapper itemMapper, EvaluationItemExample itemExample) {
        this.typeMapper = typeMapper;
        this.dictionaryMapper = dictionaryMapper;
        this.typeExample = typeExample;
        this.dictionaryExample = dictionaryExample;
        this.itemMapper = itemMapper;
        this.itemExample = itemExample;
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

    public Datagrid<EvaluationItemView> getEvaluationItems(int page, int rows, String typeId, String enable, String itemContent) {
        itemExample.clear();
        itemExample.setOrderByClause("ITEM_TYPE ASC");
        Criteria criteria = itemExample.createCriteria();
        if (typeId != null && typeId.length() > 0) {
            criteria.andItemTypeEqualTo(typeId);
        }
        if (enable != null && enable.length() > 0) {
            if ("true".equals(enable)) {
                criteria.andItemEnableNotEqualTo((short) 0);
            } else {
                criteria.andItemEnableEqualTo((short) 0);
            }
        }
        if (itemContent != null && itemContent.length() > 0) {
            criteria.andItemContentLike("%" + itemContent + "%");
        }
        PageHelper.startPage(page, rows);
        List<EvaluationItem> items = itemMapper.selectByExample(itemExample);
        PageInfo<EvaluationItem> pageInfo = new PageInfo<>(items);
        Datagrid<EvaluationItemView> result = new Datagrid<>();
        result.setTotal(pageInfo.getTotal());
        List<EvaluationItemView> itemViews = new ArrayList<>();
        for (EvaluationItem item : items) {
            itemViews.add(buildItemView(item));
        }
        result.setRows(itemViews);
        return result;
    }

    public void editEvaluationItem(EvaluationItem item) {
        itemMapper.updateByPrimaryKey(item);
    }

    private EvaluationItemView buildItemView(EvaluationItem item) {
        EvaluationItemView itemView = new EvaluationItemView();
        itemView.setId(item.getId());
        itemView.setItemContent(item.getItemContent());
        itemView.setItemEnable(item.getItemEnable());
        itemView.setEnable(item.getItemEnable() == 0 ? "否" : "是");
        itemView.setItemType(item.getItemType());
        itemView.setType(dictionaryMapper.selectByPrimaryKey(itemView.getItemType()).getDictionaryName());
        return itemView;
    }
}
