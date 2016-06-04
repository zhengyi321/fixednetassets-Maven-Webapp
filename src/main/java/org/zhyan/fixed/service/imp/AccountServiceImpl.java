package org.zhyan.fixed.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhyan.fixed.bean.Account;
import org.zhyan.fixed.dao.AccountMapper;
import org.zhyan.fixed.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountMapper accountMapper;
	
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return accountMapper.deleteByPrimaryKey(id);
	}

	public int insert(Account record) {
		// TODO Auto-generated method stub
		return accountMapper.insert(record);
	}

	public int insertSelective(Account record) {
		// TODO Auto-generated method stub
		return accountMapper.insertSelective(record);
	}

	public Account selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return accountMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Account record) {
		// TODO Auto-generated method stub
		return accountMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Account record) {
		// TODO Auto-generated method stub
		return accountMapper.updateByPrimaryKey(record);
	}

	public Account selectByYear(String year) {
		// TODO Auto-generated method stub
		return accountMapper.selectByYear(year);
	}

	public List<Account> selectAllAccount() {
		// TODO Auto-generated method stub
		return accountMapper.selectAllAccount();
	}

}
