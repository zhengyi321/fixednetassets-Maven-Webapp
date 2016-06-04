package org.zhyan.fixed.service;

import java.util.List;

import org.zhyan.fixed.bean.Role_permission;
import org.zhyan.fixed.util.Page;

public interface Role_permissionService {
    int deleteByPrimaryKey(String guid);
    
    int deleteByPid(String Pid);

    int insert(Role_permission record);

    int insertSelective(Role_permission record);

    Role_permission selectByPrimaryKey(String guid);
    
    int selectAllCounts();
    
    List<Role_permission> selectByPage(Page p);
    
    Role_permission selectByRidPid(String rid,String pid);
    
    List<Role_permission> selectRolePermissionByRid(String rid);

    int updateByPrimaryKeySelective(Role_permission record);

    int updateByPrimaryKey(Role_permission record);
}
