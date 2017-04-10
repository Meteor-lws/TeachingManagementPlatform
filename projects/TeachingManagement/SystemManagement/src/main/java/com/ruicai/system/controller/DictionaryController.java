package com.ruicai.system.controller;

import com.alibaba.fastjson.JSON;
import com.ruicai.system.entity.Tree;
import com.ruicai.system.mapper.DictionaryMapper;
import com.ruicai.system.po.Dictionary;
import com.ruicai.system.po.DictionaryExample;
import com.ruicai.system.po.DictionaryExample.Criteria;
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
        DictionaryMapper mapper = (DictionaryMapper) applicationContext.getBean("dictionaryMapper");
        DictionaryExample example = new DictionaryExample();
        Criteria criteria = example.createCriteria();
        criteria.andParentIdIsNull();
        List<Dictionary> dictionaries = mapper.selectByExample(example);
        for (Dictionary dictionary : dictionaries) {
            result.add(buildTree(dictionary));
        }
        return JSON.toJSONString(result);
    }

    @ResponseBody
    @RequestMapping(value = "/addDictionary", method = RequestMethod.POST)
    public String addDictionary(Dictionary dictionary) {
        DictionaryMapper mapper = (DictionaryMapper) applicationContext.getBean("dictionaryMapper");
        mapper.insertSelective(dictionary);
        return "添加数据字典成功";
    }

    @ResponseBody
    @RequestMapping(value = "/editDictionary", method = RequestMethod.POST)
    public String editDictionary(Dictionary dictionary) {
        DictionaryMapper mapper = (DictionaryMapper) applicationContext.getBean("dictionaryMapper");
        mapper.updateByPrimaryKeySelective(dictionary);
        return "修改数据字典成功";
    }

    @ResponseBody
    @RequestMapping(value = "/removeDictionaryById", method = RequestMethod.POST)
    public String removeDictionaryById(String id) {
        DictionaryMapper mapper = (DictionaryMapper) applicationContext.getBean("dictionaryMapper");
        mapper.deleteByPrimaryKey(id);
        return "删除数据字典成功";
    }

    @ResponseBody
    @RequestMapping(value = "/getDictionaryById", method = RequestMethod.POST)
    public String getDictionaryById(String id) {
        DictionaryMapper mapper = (DictionaryMapper) applicationContext.getBean("dictionaryMapper");
        return JSON.toJSONString(mapper.selectByPrimaryKey(id));
    }

    private Tree buildTree(Dictionary dictionary) {
        Tree tree = new Tree();
        tree.setId(dictionary.getId());
        tree.setText(dictionary.getValue());
        List<Dictionary> dictionaries = getChildren(dictionary);
        List<Tree> children = new ArrayList<>();
        for (Dictionary dict : dictionaries) {
            children.add(buildTree(dict));
        }
        tree.setChildren(children);
        return tree;
    }

    private List<Dictionary> getChildren(Dictionary dictionary) {
        DictionaryMapper mapper = (DictionaryMapper) applicationContext.getBean("dictionaryMapper");
        DictionaryExample example = new DictionaryExample();
        Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(dictionary.getId());
        example.setOrderByClause("SORT_NUMBER ASC");
        return mapper.selectByExample(example);
    }
}
