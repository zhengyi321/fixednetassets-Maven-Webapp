package org.zhyan.fixed.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhyan.fixed.bean.User;
import org.zhyan.fixed.dao.UserMapper;
import org.zhyan.fixed.service.UserService;
import org.zhyan.fixed.util.Page;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	public int deleteByPrimaryKey(String guid) {
		// TODO Auto-generated method stub
		return userMapper.deleteByGuid(guid);
	}

	public int insert(User record) {
		// TODO Auto-generated method stub
		return userMapper.insert(record);
	}

	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(record);
	}

	public User selectByPrimaryKey(String guid) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(guid);
	}

	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKey(record);
	}

	public int deleteByGuid(String guid) {
		// TODO Auto-generated method stub
		return userMapper.deleteByGuid(guid);
	}

	public User selectByUserId(String uid) {
		// TODO Auto-generated method stub
		return userMapper.selectByUserId(uid);
	}

	public List<User> selectByPage(Page p) {
		// TODO Auto-generated method stub
		return userMapper.selectByPage(p);
	}

	public int selectAllCounts() {
		// TODO Auto-generated method stub
		return userMapper.selectAllCounts();
	}

	public User selectByUsername(String name) {
		// TODO Auto-generated method stub
		return userMapper.selectByUsername(name);
	}

	public User authentication(User user) {
		// TODO Auto-generated method stub
		return userMapper.authentication(user);
	}

}
