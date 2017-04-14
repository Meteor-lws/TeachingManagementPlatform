package com.ruicai.system.service;

import com.ruicai.system.po.system.SystemDictionaryType;
import com.ruicai.system.vo.Tree;

import java.util.List;

/**
 * 数据字典类型Service接口
 *
 * Created by lws on 2017/4/11.
 */
public interface DictionaryTypeService {
    SystemDictionaryType getDictionaryTypeById(String id);

    List<Tree> getDictionaryTypes();

    void addDictionaryType(SystemDictionaryType dictionaryType);

    void editDictionaryType(SystemDictionaryType dictionaryType);

    void deleteDictionaryType(String id);

    boolean isTypeNameExist(String typeName);
}
