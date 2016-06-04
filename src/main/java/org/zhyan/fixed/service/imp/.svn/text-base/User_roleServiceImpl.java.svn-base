package org.zhyan.fixed.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhyan.fixed.bean.User_role;
import org.zhyan.fixed.dao.User_roleMapper;
import org.zhyan.fixed.service.User_roleService;

@Service
public class User_roleServiceImpl implements User_roleService{

	@Autowired
	private User_roleMapper user_roleMapper;

	public int deleteByPrimaryKey(String guid) {
		// TODO Auto-generated method stub
		return user_roleMapper.deleteByPrimaryKey(guid);
	}

	public int deleteByUid(String uid) {
		// TODO Auto-generated method stub
		return user_roleMapper.deleteByUid(uid);
	}

	public User_role selectRolesByUserId(String uid) {
		// TODO Auto-generated method stub
		return user_roleMapper.selectRolesByUserId(uid);
	}

	public int insert(User_role record) {
		// TODO Auto-generated method stub
		return user_roleMapper.insert(record);
	}

	public int insertSelective(User_role record) {
		// TODO Auto-generated method stub
		return user_roleMapper.insertSelective(record);
	}

	public User_role selectByPrimaryKey(String guid) {
		// TODO Auto-generated method stub
		return user_roleMapper.selectByPrimaryKey(guid);
	}

	public int updateByPrimaryKeySelective(User_role record) {
		// TODO Auto-generated method stub
		return user_roleMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(User_role record) {
		// TODO Auto-generated method stub
		return user_roleMapper.updateByPrimaryKey(record);
	}

	public int deleteByRid(String rid) {
		// TODO Auto-generated method stub
		return user_roleMapper.deleteByRid(rid);
	}
}
