package org.zhyan.fixed.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhyan.fixed.bean.Menu;
import org.zhyan.fixed.dao.MenuMapper;
import org.zhyan.fixed.service.MenuService;
import org.zhyan.fixed.util.Page;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return menuMapper.deleteByPrimaryKey(id);
	}

	public int insert(Menu record) {
		// TODO Auto-generated method stub
		return menuMapper.insert(record);
	}

	public int insertSelective(Menu record) {
		// TODO Auto-generated method stub
		return menuMapper.insertSelective(record);
	}

	public Menu selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return menuMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Menu record) {
		// TODO Auto-generated method stub
		return menuMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Menu record) {
		// TODO Auto-generated method stub
		return menuMapper.updateByPrimaryKey(record);
	}

	public int selectAllCount() {
		// TODO Auto-generated method stub
		return menuMapper.selectAllCount();
	}

	public List<Menu> selectMenuByPage(Page p) {
		// TODO Auto-generated method stub
		return menuMapper.selectMenuByPage(p);
	}

	public int deleteByGuid(String guid) {
		// TODO Auto-generated method stub
		return menuMapper.deleteByGuid(guid);
	}

	public Menu selectMenuBySign(String sign) {
		// TODO Auto-generated method stub
		return menuMapper.selectMenuBySign(sign);
	}

	public List<Menu> selectAllMenu() {
		// TODO Auto-generated method stub
		return menuMapper.selectAllMenu();
	}

	public Menu selectMenuByType(String type) {
		// TODO Auto-generated method stub
		return menuMapper.selectMenuByType(type);
	}
	
}
