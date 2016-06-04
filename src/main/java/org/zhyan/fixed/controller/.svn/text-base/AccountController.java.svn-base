package org.zhyan.fixed.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhyan.fixed.bean.Account;
import org.zhyan.fixed.service.AccountService;
import org.zhyan.fixed.util.MD5;

@RequestMapping(value = "account")
@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "add")
	@ResponseBody
	public boolean add(HttpServletRequest request){
		String year = request.getParameter("year");
		Account account = accountService.selectByYear(year);
		if(account == null){
			account = new Account();
			account.setGuid(MD5.getGuid());
			account.setYear(Integer.parseInt(year));
			accountService.insert(account);
			return true;
		}
		return false;
	}
	
	@RequestMapping(value = "all")
	@ResponseBody
	public List<Account> getAll(HttpServletRequest request){
		
		List<Account> accountList = accountService.selectAllAccount();	
		return accountList;
		
		
	}
	
}
