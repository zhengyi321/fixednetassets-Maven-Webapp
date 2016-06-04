package org.zhyan.fixed.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhyan.fixed.bean.Role_permission;
import org.zhyan.fixed.dao.Role_permissionMapper;
import org.zhyan.fixed.service.Role_permissionService;
import org.zhyan.fixed.util.Page;

@Service
public class Role_permissionServiceImpl implements Role_permissionService{

	@Autowired
	private Role_permissionMapper role_permissionMapper;

	public int deleteByPrimaryKey(String guid) {
		// TODO Auto-generated method stub
		return role_permissionMapper.deleteByPrimaryKey(guid);
	}

	public int insert(Role_permission record) {
		// TODO Auto-generated method stub
		return role_permissionMapper.insert(record);
	}

	public int insertSelective(Role_permission record) {
		// TODO Auto-generated method stub
		return role_permissionMapper.insertSelective(record);
	}

	public Role_permission selectByPrimaryKey(String guid) {
		// TODO Auto-generated method stub
		return role_permissionMapper.selectByPrimaryKey(guid);
	}

	public int selectAllCounts() {
		// TODO Auto-generated method stub
		return role_permissionMapper.selectAllCounts();
	}

	public List<Role_permission> selectByPage(Page p) {
		// TODO Auto-generated method stub
		return role_permissionMapper.selectByPage(p);
	}

	public Role_permission selectByRidPid(String rid, String pid) {
		// TODO Auto-generated method stub
		return role_permissionMapper.selectByRidPid(rid, pid);
	}

	public List<Role_permission> selectRolePermissionByRid(String rid) {
		// TODO Auto-generated method stub
		return role_permissionMapper.selectRolePermissionByRid(rid);
	}

	public int updateByPrimaryKeySelective(Role_permission record) {
		// TODO Auto-generated method stub
		return role_permissionMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Role_permission record) {
		// TODO Auto-generated method stub
		return role_permissionMapper.updateByPrimaryKey(record);
	}

	public int deleteByPid(String Pid) {
		// TODO Auto-generated method stub
		return role_permissionMapper.deleteByPid(Pid);
	}


}
