package com.ruicai.education.server;

import com.ruicai.education.po.education.SystemDictionary;

import java.util.List;

/**
 * Created by XM on 2017/4/13.
 */
public interface DictionaryServer {
    /**
     * 根据字典类型的英文名来查找一组字典
     *
     * @param name 字典类型
     * @return 符合条件的一组字典
     */
    public List<SystemDictionary> selectDicByName(String name);

    /**
     * 根据字典表中的value来查询字典
     * @param val value值
     * @return 符合的字典对象
     */
    public SystemDictionary selectDicByValue(String val);
}
