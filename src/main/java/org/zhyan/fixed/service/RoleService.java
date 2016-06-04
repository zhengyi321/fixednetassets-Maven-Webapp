package org.zhyan.fixed.service;

import java.util.List;

import org.zhyan.fixed.bean.Role;
import org.zhyan.fixed.util.Page;

public interface RoleService {
    int deleteByPrimaryKey(String guid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    
    
    Role selectRoleByRoleName(String rolename);
    
    Role selectRoleByRoleSign(String roleSign);
    
    int selectAllCounts();
    
    List<Role> selectByPage(Page p);
    
    List<Role> selectAllRoles();
}
