package com.ruicai.system.service;

import com.ruicai.system.po.system.SystemDictionary;

/**
 * 数据字典Service接口
 *
 * Created by lws on 2017/4/10.
 */
public interface DictionaryService extends BaseService {

    void removeDictionary(String id);

    void editDictionary(SystemDictionary dictionary);

    void addDictionary(SystemDictionary dictionary);
}
