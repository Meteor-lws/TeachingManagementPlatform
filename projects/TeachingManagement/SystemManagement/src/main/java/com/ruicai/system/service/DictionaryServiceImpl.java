package com.ruicai.system.service;

import com.ruicai.system.dao.system.SystemDictionaryMapper;
import com.ruicai.system.entity.Tree;
import com.ruicai.system.po.system.SystemDictionary;
import com.ruicai.system.po.system.SystemDictionaryExample;
import com.ruicai.system.po.system.SystemDictionaryExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据字典Service类
 *
 * Created by lws on 2017/4/10.
 */
@Service("DictionaryService")
public class DictionaryServiceImpl implements DictionaryService {

    private final SystemDictionaryMapper mapper;

    @Autowired
    public DictionaryServiceImpl(SystemDictionaryMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public SystemDictionary findById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Tree> findAll() {
        List<Tree> result = new ArrayList<>();
        SystemDictionaryExample example = new SystemDictionaryExample();
        Criteria criteria = example.createCriteria();
        criteria.andParentIdIsNull();
        List<SystemDictionary> dictionaries = mapper.selectByExample(example);
        for (SystemDictionary dictionary : dictionaries) {
            result.add(buildTree(dictionary));
        }
        return result;
    }

    public void deleteById(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    public void editDictionary(SystemDictionary dictionary) {
        mapper.updateByPrimaryKeySelective(dictionary);
    }

    public void addDictionary(SystemDictionary dictionary) {
        mapper.insertSelective(dictionary);
    }

    private Tree buildTree(SystemDictionary dictionary) {
        Tree tree = new Tree();
        tree.setId(dictionary.getId());
        tree.setText(dictionary.getDictionaryName());
        List<SystemDictionary> dictionaries = getChildren(dictionary);
        List<Tree> children = new ArrayList<>();
        for (SystemDictionary dict : dictionaries) {
            children.add(buildTree(dict));
        }
        tree.setChildren(children);
        return tree;
    }

    private List<SystemDictionary> getChildren(SystemDictionary dictionary) {
        SystemDictionaryExample example = new SystemDictionaryExample();
        Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(dictionary.getId());
        example.setOrderByClause("DICTIONARY_SORT_NUMBER ASC");
        return mapper.selectByExample(example);
    }
}
