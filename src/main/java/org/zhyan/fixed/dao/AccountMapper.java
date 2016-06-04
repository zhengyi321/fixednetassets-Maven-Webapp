package org.zhyan.fixed.dao;

import java.util.List;

import org.zhyan.fixed.bean.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
    
    Account selectByYear(String year);
    
    List<Account> selectAllAccount();
}