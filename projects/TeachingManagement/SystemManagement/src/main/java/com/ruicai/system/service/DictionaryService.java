package com.ruicai.system.service;

import com.alibaba.fastjson.JSON;
import com.ruicai.system.dao.system.SystemDictionaryMapper;
import com.ruicai.system.entity.Tree;
import com.ruicai.system.po.system.SystemDictionary;
import com.ruicai.system.po.system.SystemDictionaryExample;
import com.ruicai.system.po.system.SystemDictionaryExample.Criteria;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据字典Service类
 *
 * Created by lws on 2017/4/10.
 */
public class DictionaryService {

    private final ApplicationContext applicationContext;

    public DictionaryService() {
        applicationContext = new ClassPathXmlApplicationContext("spring/application-context.xml");
    }

    public String getDictionary(String id) {
        SystemDictionaryMapper mapper = (SystemDictionaryMapper) applicationContext.getBean("systemDictionaryMapper");
        return JSON.toJSONString(mapper.selectByPrimaryKey(id));
    }

    public String getDictionaries() {
        List<Tree> result = new ArrayList<>();
        SystemDictionaryMapper mapper = (SystemDictionaryMapper) applicationContext.getBean("systemDictionaryMapper");
        SystemDictionaryExample example = new SystemDictionaryExample();
        Criteria criteria = example.createCriteria();
        criteria.andParentIdIsNull();
        List<SystemDictionary> dictionaries = mapper.selectByExample(example);
        for (SystemDictionary dictionary : dictionaries) {
            result.add(buildTree(dictionary));
        }
        return JSON.toJSONString(result);
    }

    public void removeDictionary(String id) {
        SystemDictionaryMapper mapper = (SystemDictionaryMapper) applicationContext.getBean("systemDictionaryMapper");
        mapper.deleteByPrimaryKey(id);
    }

    public void editDictionary(SystemDictionary dictionary) {
        SystemDictionaryMapper mapper = (SystemDictionaryMapper) applicationContext.getBean("systemDictionaryMapper");
        mapper.updateByPrimaryKeySelective(dictionary);
    }

    public void addDictionary(SystemDictionary dictionary) {
        SystemDictionaryMapper mapper = (SystemDictionaryMapper) applicationContext.getBean("systemDictionaryMapper");
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
        SystemDictionaryMapper mapper = (SystemDictionaryMapper) applicationContext.getBean("systemDictionaryMapper");
        SystemDictionaryExample example = new SystemDictionaryExample();
        Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(dictionary.getId());
        example.setOrderByClause("DICTIONARY_SORT_NUMBER ASC");
        return mapper.selectByExample(example);
    }
}
