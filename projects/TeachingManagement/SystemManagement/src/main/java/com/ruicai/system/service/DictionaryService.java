package com.ruicai.system.service;

import com.ruicai.system.po.system.SystemDictionary;
import com.ruicai.system.vo.Datagrid;

/**
 * 数据字典Service接口
 *
 * Created by lws on 2017/4/11.
 */
public interface DictionaryService {
    Datagrid<SystemDictionary> getDictionariesByTypeId(String typeId);
}
