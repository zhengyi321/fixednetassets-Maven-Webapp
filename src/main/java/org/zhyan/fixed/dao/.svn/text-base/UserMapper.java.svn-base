package org.zhyan.fixed.dao;

import java.util.List;

import org.zhyan.fixed.bean.User;
import org.zhyan.fixed.util.Page;

public interface UserMapper {
    int deleteByPrimaryKey(String guid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    
    int deleteByGuid(String guid);
    
    User selectByUserId(String uid);
    
    List<User> selectByPage(Page p);
    
    int selectAllCounts();
    
    User selectByUsername(String name);
    
    User authentication(User user);
}