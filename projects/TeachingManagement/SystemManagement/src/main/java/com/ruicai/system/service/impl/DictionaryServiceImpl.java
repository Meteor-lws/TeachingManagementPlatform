package com.ruicai.system.service.impl;

import com.ruicai.system.mapper.system.SystemDictionaryMapper;
import com.ruicai.system.po.system.SystemDictionary;
import com.ruicai.system.po.system.SystemDictionaryExample;
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

    @Override
    public SystemDictionary getDictionaryById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Datagrid<SystemDictionary> getDictionariesByTypeId(String typeId) {
        Datagrid<SystemDictionary> datagrid = new Datagrid<>();
        if (typeId != null) {
            example.clear();
            example.createCriteria().andDictionaryTypeIdEqualTo(typeId);
            example.setOrderByClause("DICTIONARY_SORT_NUMBER ASC");
            List<SystemDictionary> dictionaries = mapper.selectByExample(example);
            datagrid.setTotal(dictionaries.size());
            datagrid.setRows(dictionaries);
        }
        return datagrid;
    }

    @Override
    public void addDictionary(SystemDictionary dictionary) {
        mapper.insertSelective(dictionary);
    }

    @Override
    public void editDictionary(SystemDictionary dictionary) {
        mapper.updateByPrimaryKeySelective(dictionary);
    }

    @Override
    public void deleteDictionaries(List<SystemDictionary> dictionaries) {
        for (SystemDictionary dictionary : dictionaries) {
            mapper.deleteByPrimaryKey(dictionary.getId());
        }
    }
}
