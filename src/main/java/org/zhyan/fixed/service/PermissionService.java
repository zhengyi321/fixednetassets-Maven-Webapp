package org.zhyan.fixed.service;

import java.util.List;

import org.zhyan.fixed.bean.Permission;
import org.zhyan.fixed.util.Page;

public interface PermissionService {
    int deleteByPrimaryKey(String guid);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String guid);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    
    int selectAllCounts();
    
    int selectMaxMenuType();
    
    List<Permission> selectByPage(Page p);
    
    Permission selectPermissionBySign(String sign);
    
    Permission selectPermissionByUrl(String url);
    
    Permission selectPermissionByMenuType(String type);
}
