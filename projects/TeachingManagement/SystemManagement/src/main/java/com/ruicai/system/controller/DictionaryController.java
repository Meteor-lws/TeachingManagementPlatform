package com.ruicai.system.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.system.entity.Tree;
import com.ruicai.system.mapper.SystemDictionaryMapper;
import com.ruicai.system.po.SystemDictionary;
import com.ruicai.system.po.SystemDictionaryExample;
import com.ruicai.system.po.SystemDictionaryExample.Criteria;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据字典控制器
 *
 * Created by XuMing on 2017/4/5.
 */
@SuppressWarnings("SameReturnValue")
@Controller
public class DictionaryController {
    private final ApplicationContext applicationContext;

    DictionaryController() {
        applicationContext = new ClassPathXmlApplicationContext("spring/application-context.xml");
    }

    @RequestMapping(value = "/dictionary", method = RequestMethod.GET)
    public String dictionary() {
        return "dictionary";
    }

    @ResponseBody
    @RequestMapping(value = "/dictionaryData", method = RequestMethod.POST)
    public String dictionaryData() {
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

    @ResponseBody
    @RequestMapping(value = "/addDictionary", method = RequestMethod.POST)
    public String addDictionary(SystemDictionary dictionary) {
        SystemDictionaryMapper mapper = (SystemDictionaryMapper) applicationContext.getBean("systemDictionaryMapper");
        mapper.insertSelective(dictionary);
        return "添加数据字典成功";
    }

    @ResponseBody
    @RequestMapping(value = "/editDictionary", method = RequestMethod.POST)
    public String editDictionary(SystemDictionary dictionary) {
        SystemDictionaryMapper mapper = (SystemDictionaryMapper) applicationContext.getBean("systemDictionaryMapper");
        mapper.updateByPrimaryKeySelective(dictionary);
        return "修改数据字典成功";
    }

    @ResponseBody
    @RequestMapping(value = "/removeDictionaryById", method = RequestMethod.POST)
    public String removeDictionaryById(String id) {
        SystemDictionaryMapper mapper = (SystemDictionaryMapper) applicationContext.getBean("systemDictionaryMapper");
        mapper.deleteByPrimaryKey(id);
        return "删除数据字典成功";
    }

    @ResponseBody
    @RequestMapping(value = "/getDictionaryById", method = RequestMethod.POST)
    public String getDictionaryById(String id) {
        SystemDictionaryMapper mapper = (SystemDictionaryMapper) applicationContext.getBean("systemDictionaryMapper");
        return JSON.toJSONString(mapper.selectByPrimaryKey(id));
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
