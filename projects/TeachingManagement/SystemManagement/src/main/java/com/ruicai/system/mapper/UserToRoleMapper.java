package com.ruicai.system.mapper;

import com.ruicai.system.po.UserToRoleExample;
import com.ruicai.system.po.UserToRoleKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserToRoleMapper {
    int countByExample(UserToRoleExample example);

    int deleteByExample(UserToRoleExample example);

    int deleteByPrimaryKey(UserToRoleKey key);

    int insert(UserToRoleKey record);

    int insertSelective(UserToRoleKey record);

    List<UserToRoleKey> selectByExample(UserToRoleExample example);

    int updateByExampleSelective(@Param("record") UserToRoleKey record, @Param("example") UserToRoleExample example);

    int updateByExample(@Param("record") UserToRoleKey record, @Param("example") UserToRoleExample example);
}