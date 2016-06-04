package org.zhyan.fixed.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhyan.fixed.bean.Permission;
import org.zhyan.fixed.dao.PermissionMapper;
import org.zhyan.fixed.service.PermissionService;
import org.zhyan.fixed.util.Page;

@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private PermissionMapper permissionMapper;
	
	public int deleteByPrimaryKey(String guid) {
		// TODO Auto-generated method stub
		return permissionMapper.deleteByPrimaryKey(guid);
	}

	public int insert(Permission record) {
		// TODO Auto-generated method stub
		return permissionMapper.insert(record);
	}

	public int insertSelective(Permission record) {
		// TODO Auto-generated method stub
		return permissionMapper.insertSelective(record);
	}

	public Permission selectByPrimaryKey(String guid) {
		// TODO Auto-generated method stub
		return permissionMapper.selectByPrimaryKey(guid);
	}

	public int updateByPrimaryKeySelective(Permission record) {
		// TODO Auto-generated method stub
		return permissionMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Permission record) {
		// TODO Auto-generated method stub
		return permissionMapper.updateByPrimaryKey(record);
	}

	public int selectAllCounts() {
		// TODO Auto-generated method stub
		return permissionMapper.selectAllCounts();
	}

	public int selectMaxMenuType() {
		// TODO Auto-generated method stub
		return permissionMapper.selectMaxMenuType();
	}

	public List<Permission> selectByPage(Page p) {
		// TODO Auto-generated method stub
		return permissionMapper.selectByPage(p);
	}



	public Permission selectPermissionBySign(String sign) {
		// TODO Auto-generated method stub
		return permissionMapper.selectPermissionBySign(sign);
	}

	public Permission selectPermissionByUrl(String url) {
		// TODO Auto-generated method stub
		return permissionMapper.selectPermissionByUrl(url);
	}

	public Permission selectPermissionByMenuType(String type) {
		// TODO Auto-generated method stub
		return permissionMapper.selectPermissionByMenuType(type);
	}

}
