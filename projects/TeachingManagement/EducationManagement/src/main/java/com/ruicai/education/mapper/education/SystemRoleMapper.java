package com.ruicai.education.mapper.education;

import com.ruicai.education.po.education.SystemRole;
import com.ruicai.education.po.education.SystemRoleExample;
import com.ruicai.education.po.education.UserToRoleKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemRoleMapper {
    int countByExample(SystemRoleExample example);

    int deleteByExample(SystemRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(SystemRole record);

    int insertSelective(SystemRole record);

    List<SystemRole> selectByExample(SystemRoleExample example);

    SystemRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SystemRole record, @Param("example") SystemRoleExample example);

    int updateByExample(@Param("record") SystemRole record, @Param("example") SystemRoleExample example);

    int updateByPrimaryKeySelective(SystemRole record);

    int updateByPrimaryKey(SystemRole record);

    List<SystemRole> selectAllTeacher();

    List<SystemRole> getUserRole(String userId);

    void deleteRoleByUserID(String userId);

    void addRole(UserToRoleKey utr);

    List<SystemRole> selectRoleByCode(String RoleCode);
}