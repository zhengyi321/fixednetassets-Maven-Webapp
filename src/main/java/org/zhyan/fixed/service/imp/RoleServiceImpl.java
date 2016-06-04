package org.zhyan.fixed.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhyan.fixed.bean.Role;
import org.zhyan.fixed.dao.RoleMapper;
import org.zhyan.fixed.service.RoleService;
import org.zhyan.fixed.util.Page;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;

	public int deleteByPrimaryKey(String guid) {
		// TODO Auto-generated method stub
		return roleMapper.deleteByPrimaryKey(guid);
	}

	public int insert(Role record) {
		// TODO Auto-generated method stub
		return roleMapper.insert(record);
	}

	public int insertSelective(Role record) {
		// TODO Auto-generated method stub
		return roleMapper.insertSelective(record);
	}

	public Role selectByPrimaryKey(String guid) {
		// TODO Auto-generated method stub
		return roleMapper.selectByPrimaryKey(guid);
	}

	public int updateByPrimaryKeySelective(Role record) {
		// TODO Auto-generated method stub
		return roleMapper.updateByPrimaryKey(record);
	}

	public int updateByPrimaryKey(Role record) {
		// TODO Auto-generated method stub
		return roleMapper.updateByPrimaryKey(record);
	}


	public Role selectRoleByRoleName(String rolename) {
		// TODO Auto-generated method stub
		return roleMapper.selectRoleByRoleName(rolename);
	}

	public Role selectRoleByRoleSign(String roleSign) {
		// TODO Auto-generated method stub
		return roleMapper.selectRoleByRoleSign(roleSign);
	}

	public int selectAllCounts() {
		// TODO Auto-generated method stub
		return roleMapper.selectAllCounts();
	}

	public List<Role> selectByPage(Page p) {
		// TODO Auto-generated method stub
		return roleMapper.selectByPage(p);
	}

	public List<Role> selectAllRoles() {
		// TODO Auto-generated method stub
		return roleMapper.selectAllRoles();
	}
}
