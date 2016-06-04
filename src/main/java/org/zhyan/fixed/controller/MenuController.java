package org.zhyan.fixed.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zhyan.fixed.bean.Menu;
import org.zhyan.fixed.service.MenuService;
import org.zhyan.fixed.util.MD5;
import org.zhyan.fixed.util.Page;


@RequestMapping(value = "menu")
@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "index")
	@ResponseBody
	public ModelAndView index(HttpServletRequest request,Map<String,Object> resultMap){
		String currentPage = request.getParameter("page");
		  try{
			  Subject subject = SecurityUtils.getSubject();
			  if(subject.isAuthenticated())
			  {
				  int allCount = menuService.selectAllCount();
				  if(allCount == 0){
						allCount = 1;
					}
				  Page p = new Page(allCount,Integer.parseInt(currentPage));
				  List<Menu> menuList = menuService.selectMenuByPage(p);
				  if(menuList.size() >0)
				  {
					  resultMap.put("menuList", menuList);
					  resultMap.put("nums", allCount);
					  resultMap.put("pages", p);
				  } else {
						resultMap.put("menuList",menuList);
						resultMap.put("nums",0);
						resultMap.put("pages",p);
				  }
				  resultMap.put("currentpage", "菜单管理");
			  }else
			  {
				  return new ModelAndView("../login");
			  }
		  }catch(AuthenticationException e)
		  {
			  return new ModelAndView("../login");
		  }
		
		return new ModelAndView("/menu/allmenu");
	}
	
	@RequestMapping(value = "add")
	@ResponseBody
	public ModelAndView add(HttpServletRequest request){
		try{
			  Subject subject = SecurityUtils.getSubject();
			  if(subject.isAuthenticated())
			  {	
				  
			  }else
			  {
				  return new ModelAndView("../login");
			  }
		  }catch(AuthenticationException e)
		  {
			  return new ModelAndView("../login");
		  }
		return new ModelAndView("/menu/add");
	}
	
	@RequestMapping(value = "addsubmit")
	@ResponseBody
	public ModelAndView addSubmit(HttpServletRequest request,Map<String,Object> resultMap){
		String menu = request.getParameter("menu");
		String type = request.getParameter("type");
		String sign = request.getParameter("sign");
		
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				Menu tempMenu = menuService.selectMenuByType(type);
				if(tempMenu == null){
					tempMenu = new Menu();
					tempMenu.setGuid(MD5.getGuid());
					tempMenu.setName(menu);
					if(MD5.isNumber(type)){
						tempMenu.setType(Integer.parseInt(type));
					}else{
						tempMenu.setType(0);
					}
					
					tempMenu.setSign(sign);
					menuService.insert(tempMenu);
				}
				int allCounts = menuService.selectAllCount();
				if(allCounts == 0){
					allCounts = 1;
				}
				Page p = new Page(allCounts,1);
				List<Menu> menuList = menuService.selectMenuByPage(p);
				if(menuList.size() > 0){
					resultMap.put("menuList", menuList);
					resultMap.put("nums", allCounts);
					resultMap.put("pages", p);
				}
			}else{
				return new ModelAndView("../login");
			}
				
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		
		return new ModelAndView("/menu/allmenu");
	}
	
	
	@RequestMapping(value = "delete")
	@ResponseBody
	public boolean delete(HttpServletRequest request){
		String menuId = request.getParameter("guid");
		String[] menuArray = menuId.split(",");
		try{
			  Subject subject = SecurityUtils.getSubject();
			  if(subject.isAuthenticated()){	
				 if(menuArray.length > 0){
					 for(int i = 0; i  < menuArray.length;i++){
						 menuService.deleteByGuid(menuArray[i]);
					 }
				 }  
			  }else{
				 return false;
			  }
		  }catch(AuthenticationException e)
		  {
			  return false;
		  }
		return true;
	}
}
