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
    SystemDictionary getDictionaryById(String id);

    Datagrid<SystemDictionary> getDictionariesByTypeId(String typeId);

    void addDictionary(SystemDictionary dictionary);

    void editDictionary(SystemDictionary dictionary);

    void deleteDictionaries(List<SystemDictionary> dictionaries);
}
