package com.ruicai.system.service.impl;

import com.ruicai.system.mapper.system.SystemDictionaryTypeMapper;
import com.ruicai.system.po.system.SystemDictionaryType;
import com.ruicai.system.po.system.SystemDictionaryTypeExample;
import com.ruicai.system.service.DictionaryTypeService;
import com.ruicai.system.vo.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据字典类型Service接口实现类
 *
 * Created by lws on 2017/4/11.
 */
@Service("DictionaryTypeService")
public class DictionaryTypeServiceImpl implements DictionaryTypeService {

    private final SystemDictionaryTypeMapper mapper;

    private final SystemDictionaryTypeExample example;

    @Autowired
    public DictionaryTypeServiceImpl(SystemDictionaryTypeMapper mapper, SystemDictionaryTypeExample example) {
        this.mapper = mapper;
        this.example = example;
    }

    @Override
    public List<Tree> getDictionaryTypes() {
        List<Tree> result = new ArrayList<>();
        example.clear();
        example.createCriteria().andParentIdIsNull();
        List<SystemDictionaryType> dictionaryTypes = mapper.selectByExample(example);
        for (SystemDictionaryType dictionaryType : dictionaryTypes) {
            result.add(buildTree(dictionaryType));
        }
        return result;
    }

    public void addDictionaryType(SystemDictionaryType dictionaryType) {
        mapper.insertSelective(dictionaryType);
    }

    @Override
    public void deleteDictionaryType(String id) {
        mapper.deleteByPrimaryKey(id);
    }

    private Tree buildTree(SystemDictionaryType dictionaryType) {
        Tree tree = new Tree();
        tree.setId(dictionaryType.getId());
        tree.setText(dictionaryType.getDictionaryTypeDescribe());
        tree.setChildren(getChildren(dictionaryType));
        return tree;
    }

    private List<Tree> getChildren(SystemDictionaryType dictionaryType) {
        List<Tree> result = new ArrayList<>();
        example.clear();
        example.createCriteria().andParentIdEqualTo(dictionaryType.getId());
        example.setOrderByClause("DICTIONARY_TYPE_SORT_NUMBER ASC");
        List<SystemDictionaryType> dictionaryTypes = mapper.selectByExample(example);
        for (SystemDictionaryType type : dictionaryTypes) {
            result.add(buildTree(type));
        }
        return result;
    }
}
