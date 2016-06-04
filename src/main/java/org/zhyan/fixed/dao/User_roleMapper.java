package org.zhyan.fixed.dao;

import org.zhyan.fixed.bean.User_role;

public interface User_roleMapper {
    int deleteByPrimaryKey(String guid);
    
    int deleteByUid(String uid);
    
    int deleteByRid(String rid);

    User_role selectRolesByUserId(String uid);
    
    int insert(User_role record);

    int insertSelective(User_role record);

    User_role selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(User_role record);

    int updateByPrimaryKey(User_role record);
}