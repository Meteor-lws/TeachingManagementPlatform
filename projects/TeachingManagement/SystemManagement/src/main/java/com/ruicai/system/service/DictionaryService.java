package com.ruicai.system.service;

import com.ruicai.system.po.system.SystemDictionary;
import com.ruicai.system.vo.Datagrid;

import java.util.List;

/**
 * 数据字典Service接口
 *
 * Created by lws on 2017/4/11.
 */
public interface DictionaryService {
    boolean isDictionaryNameExist(String dictionaryName);

    void addDictionary(SystemDictionary dictionary);

    void deleteDictionaries(List<SystemDictionary> dictionaries);

    void editDictionary(SystemDictionary dictionary);

    SystemDictionary getDictionaryById(String id);

    Datagrid<SystemDictionary> getDictionaries(String type, String name, String value, String describe, int page, int rows);
}
