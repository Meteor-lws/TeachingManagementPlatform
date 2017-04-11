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

    @Autowired
    private SystemDictionaryTypeMapper mapper;

    @Override
    public List<Tree> getDictionaryTypes() {
        SystemDictionaryTypeExample typeExample = new SystemDictionaryTypeExample();
        typeExample.createCriteria().andParentIdIsNull();
        List<SystemDictionaryType> dictionaryTypes = mapper.selectByExample(typeExample);
        List<Tree> result = new ArrayList<>();
        for (SystemDictionaryType dictionaryType : dictionaryTypes) {
            result.add(buildTree(dictionaryType));
        }
        return result;
    }

    private Tree buildTree(SystemDictionaryType dictionaryType) {
        SystemDictionaryTypeExample typeExample = new SystemDictionaryTypeExample();
        typeExample.createCriteria().andParentIdEqualTo(dictionaryType.getId());
        Tree result = new Tree();
        List<Tree> children = new ArrayList<>();
        result.setId(dictionaryType.getId());
        result.setText(dictionaryType.getDictionaryTypeName());
        List<SystemDictionaryType> dictionaryTypes = mapper.selectByExample(typeExample);
        for (SystemDictionaryType type : dictionaryTypes) {
            children.add(buildTree(type));
        }
        return result;
    }
}
