package com.ruicai.education.server.impl;

import com.ruicai.education.po.education.SystemDictionary;
import com.ruicai.education.server.DictionaryServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XM on 2017/4/13.
 */
@Service
public class DicationaryServerImpl implements DictionaryServer {

    @Autowired
    private com.ruicai.education.mapper.education.SystemDictionaryMapper systemDictionaryMapper;

    @Override
    public List<SystemDictionary> selectDicByName(String name){
        return systemDictionaryMapper.selectDicByName(name);
    }

    @Override
    public SystemDictionary selectDicByValue(String val) {
        return systemDictionaryMapper.selectDicByValue(val);
    }
}
