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
import org.zhyan.fixed.bean.Role;
import org.zhyan.fixed.service.RoleService;
import org.zhyan.fixed.service.User_roleService;
import org.zhyan.fixed.util.MD5;
import org.zhyan.fixed.util.Page;

@RequestMapping(value = "role")
@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private User_roleService userRoleService;
	
	@RequestMapping(value = "index")
	@ResponseBody
	public ModelAndView index(HttpServletRequest request,Map<String,Object> resultMap){
		String currentIndex = request.getParameter("page");
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated())
			  {
				int allCount = roleService.selectAllCounts();
				if(allCount == 0){
					allCount = 1;
				}
				Page p = new Page(allCount,Integer.parseInt(currentIndex));
				List<Role> roleList = roleService.selectByPage(p);
				if(roleList.size() > 0)
				{
					resultMap.put("roleList",roleList);
					resultMap.put("nums", allCount);
					resultMap.put("pages", p);
				} else {
					resultMap.put("roleList",roleList);
					resultMap.put("nums",0);
					resultMap.put("pages",p);
				}
				 resultMap.put("currentpage", "角色管理管理");
			  }else
			  {
				  return new ModelAndView("../login");
			  }
		}catch(AuthenticationException e)
		{
			return new ModelAndView("../login");
		}
		
		
		return new ModelAndView("/role/allrole");
	}
	@RequestMapping(value = "add")
	@ResponseBody
	public ModelAndView add(HttpServletRequest request){
		
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				
			}else{
				return new ModelAndView("../login");
			}
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		
		return new ModelAndView("/role/add");
	}
	
	@RequestMapping(value = "addsubmit")
	@ResponseBody
	public ModelAndView addSubmit(HttpServletRequest request,Map<String,Object> resultMap){
		String name = request.getParameter("name");
		String sign = request.getParameter("sign");
		String describ = request.getParameter("describ");
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				Role role = roleService.selectRoleByRoleSign(sign);
				if(role == null){
					role = new Role();
					role.setGuid(MD5.getGuid());
					role.setRoleName(name);
					role.setRoleSign(sign);
					role.setDescription(describ);
					roleService.insert(role);
				}
				int allCounts = roleService.selectAllCounts();
				if(allCounts == 0){
					allCounts = 1;
				}
				Page p = new Page(allCounts,1);
				List<Role> roleList = roleService.selectByPage(p);
				if(roleList.size() > 0){
					resultMap.put("nums", allCounts);
					resultMap.put("pages", p);
					resultMap.put("roleList", roleList);
				}
			}else{
				return new ModelAndView("../login");
			}
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		
		return new ModelAndView("/role/allrole");
	}
	
	@RequestMapping(value = "delete")
	@ResponseBody
	public boolean delete(HttpServletRequest request){
		
		String guid = request.getParameter("guid");
		String[] guidArray = guid.split(",");
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				for(int i=0;i<guidArray.length;i++){
					userRoleService.deleteByRid(guidArray[i]);
					roleService.deleteByPrimaryKey(guidArray[i]);
				}
			}else{
				return false;
			}
		}catch(AuthenticationException e){
			return false;
		}
		
		return true;
	}
}
