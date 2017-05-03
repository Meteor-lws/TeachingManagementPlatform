package com.ruicai.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruicai.system.mapper.system.SystemDictionaryMapper;
import com.ruicai.system.po.system.SystemDictionary;
import com.ruicai.system.po.system.SystemDictionaryExample;
import com.ruicai.system.po.system.SystemDictionaryExample.Criteria;
import com.ruicai.system.service.DictionaryService;
import com.ruicai.system.vo.Datagrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据字典Service接口实现类
 *
 * Created by lws on 2017/4/11.
 */
@Service("DictionaryService")
public class DictionaryServiceImpl implements DictionaryService {

    private final SystemDictionaryMapper mapper;

    private final SystemDictionaryExample example;


    @Autowired
    public DictionaryServiceImpl(SystemDictionaryMapper mapper, SystemDictionaryExample example) {
        this.mapper = mapper;
        this.example = example;
    }

    public boolean isDictionaryNameExist(String dictionaryName) {
        example.clear();
        example.createCriteria().andDictionaryNameEqualTo(dictionaryName);
        List<SystemDictionary> dictionaries = mapper.selectByExample(example);
        return dictionaries.size() > 0;
    }

    public void addDictionary(SystemDictionary dictionary) {
        mapper.insertSelective(dictionary);
    }

    public void deleteDictionaries(List<SystemDictionary> dictionaries) {
        for (SystemDictionary dictionary : dictionaries) {
            mapper.deleteByPrimaryKey(dictionary.getId());
        }
    }

    public void editDictionary(SystemDictionary dictionary) {
        mapper.updateByPrimaryKeySelective(dictionary);
    }

    public SystemDictionary getDictionaryById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    public Datagrid<SystemDictionary> getDictionaries(String type, String name, String value, String describe, int page, int rows) {
        Datagrid<SystemDictionary> datagrid = new Datagrid<>();
        if (type != null) {
            example.clear();
            Criteria criteria = example.createCriteria();
            criteria.andDictionaryTypeIdEqualTo(type);
            if (name != null && name.trim().length() > 0) {
                criteria.andDictionaryNameLike(fixString(name));
            }
            if (value != null && value.trim().length() > 0) {
                criteria.andDictionaryValueLike(fixString(value));
            }
            if (describe != null && describe.trim().length() > 0) {
                criteria.andDictionaryDescribeLike(fixString(describe));
            }
            example.setOrderByClause("DICTIONARY_SORT_NUMBER ASC");
            PageHelper.startPage(page, rows);
            List<SystemDictionary> dictionaries = mapper.selectByExample(example);
            PageInfo<SystemDictionary> pageInfo = new PageInfo<>(dictionaries);
            datagrid.setTotal(pageInfo.getTotal());
            datagrid.setRows(dictionaries);
        }
        return datagrid;
    }

    @Override
    public List<SystemDictionary> selectDicByType(String typeName) {
        return mapper.selectDicByType(typeName);
    }


    private String fixString(String string) {
        return "%" + string + "%";
    }
}
