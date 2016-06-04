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
import org.zhyan.fixed.bean.User;
import org.zhyan.fixed.bean.User_role;
import org.zhyan.fixed.service.RoleService;
import org.zhyan.fixed.service.UserService;
import org.zhyan.fixed.service.User_roleService;
import org.zhyan.fixed.util.GetIP;
import org.zhyan.fixed.util.MD5;
import org.zhyan.fixed.util.Page;
import org.zhyan.fixed.util.TimeUtil;

@RequestMapping(value = "user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
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
			if(subject.isAuthenticated()){
				int allCounts = userService.selectAllCounts();
				if(allCounts == 0){
					allCounts = 1;
				}
				Page p = new Page(allCounts,Integer.parseInt(currentIndex));
				List<User> userList = userService.selectByPage(p);
				if(userList.size() > 0){
					resultMap.put("userList",userList);
					resultMap.put("nums",allCounts);
					resultMap.put("pages",p);
				}else{
					resultMap.put("userList",userList);
					resultMap.put("nums",0);
					resultMap.put("pages",p);
				}
					
				 resultMap.put("currentpage", "用户管理");
			}else{
				return new ModelAndView("../login");
			}
				
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		
		return new ModelAndView("/user/alluser");
	}
	
	@RequestMapping(value = "add")
	@ResponseBody
	public ModelAndView add(HttpServletRequest request,Map<String,Object> resultMap){
		
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				List<Role> roleList = roleService.selectAllRoles();
				if(roleList.size() > 0){
					resultMap.put("roleList", roleList);
				}
			}else{
				return new ModelAndView("../login");
			}
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		
		return new ModelAndView("/user/add");
	}
	@RequestMapping(value="addsubmit")
	@ResponseBody
	public ModelAndView addSubmit(HttpServletRequest request,Map<String,Object> resultMap){
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String rid = request.getParameter("role");
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				User user = userService.selectByUsername(name);
				if(user == null)
				{
					user = new User();
					user.setCreateTime(TimeUtil.getCurrentTimeDate());
					user.setGuid(MD5.getGuid());
					user.setIpAddress(GetIP.getIpAddress(request));
					user.setName(name);
					user.setPass(MD5.passToMd5(pass));
					userService.insert(user);
					User_role userRole = new User_role();
					userRole.setGuid(MD5.getGuid());
					userRole.setRid(rid);
					userRole.setUid(user.getGuid());
					userRoleService.insert(userRole);
				}
				int allCounts = userService.selectAllCounts();
				if(allCounts == 0){
					allCounts = 1;
				}
				Page p = new Page(allCounts,1);
				List<User> userList = userService.selectByPage(p);
				if(userList.size() > 0){
					resultMap.put("userList", userList);
					resultMap.put("nums", allCounts);
					resultMap.put("pages", p);
				}
			} else {
				return new ModelAndView("../login");
			}
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		
		
		return new ModelAndView("/user/alluser");
	}
	
	@RequestMapping(value = "delete")
	@ResponseBody
	public boolean delete(HttpServletRequest request){
		String guid = request.getParameter("guid");
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				String[] guidArray = guid.split(",");
				for(int i = 0;i < guidArray.length;i++){
					userRoleService.deleteByUid(guidArray[i]);
					userService.deleteByGuid(guidArray[i]);
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
