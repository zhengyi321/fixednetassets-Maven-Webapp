package org.zhyan.fixed.service;

import java.util.List;

import org.zhyan.fixed.bean.Menu;
import org.zhyan.fixed.util.Page;

public interface MenuService {
	
	List<Menu> selectAllMenu();
	
	int deleteByGuid(String guid);
	
	int selectAllCount();
	
	Menu selectMenuBySign(String sign);
	
	Menu selectMenuByType(String type);
	
	List<Menu> selectMenuByPage(Page p);

    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}
