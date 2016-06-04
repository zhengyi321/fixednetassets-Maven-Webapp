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
import org.zhyan.fixed.bean.Permission;
import org.zhyan.fixed.service.MenuService;
import org.zhyan.fixed.service.PermissionService;
import org.zhyan.fixed.service.Role_permissionService;
import org.zhyan.fixed.util.MD5;
import org.zhyan.fixed.util.Page;

@RequestMapping(value = "permission")
@Controller
public class PermissionController {

	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private Role_permissionService rolePermissionService;
	
	@RequestMapping(value = "index")
	@ResponseBody
	public ModelAndView index(HttpServletRequest request,Map<String,Object> resultMap){
		
		String currentIndex = request.getParameter("page");
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				int allCounts = permissionService.selectAllCounts();
				if(allCounts == 0){
					allCounts = 1;
				}
				Page p = new Page(allCounts,Integer.parseInt(currentIndex));
				List<Permission> permissionList = permissionService.selectByPage(p);
				if(permissionList.size() > 0){
					resultMap.put("permissionList",permissionList);
					resultMap.put("nums",allCounts);
					resultMap.put("pages",p);
				} else {
					resultMap.put("permissionList",permissionList);
					resultMap.put("nums",0);
					resultMap.put("pages",p);
				}
				 resultMap.put("currentpage", "权限管理");
			}else{
				return new ModelAndView("../login");
			}
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		
		return new ModelAndView("/permission/allpermission");
	}
	
	@RequestMapping(value = "add")
	@ResponseBody
	public ModelAndView add(HttpServletRequest request,Map<String,Object> resultMap){
		
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				List<Menu> menuList = menuService.selectAllMenu();
				if(menuList.size() > 0){
					resultMap.put("menuList", menuList);
				}
			}else{
				return new ModelAndView("../login");
			}
				
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		
		
		return new ModelAndView("/permission/add");
	}
	
	@RequestMapping(value = "addsubmit")
	@ResponseBody
	public ModelAndView addSubmit(HttpServletRequest request,Map<String,Object> resultMap){
		String name = request.getParameter("name");
		String sign = request.getParameter("sign");
		String describ = request.getParameter("describ");
		String url = request.getParameter("url");
		String type = request.getParameter("type");
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				Permission permission = permissionService.selectPermissionBySign(sign);
				Menu menu = menuService.selectMenuByType(type);
				if(permission == null){
					permission = new Permission();
					permission.setGuid(MD5.getGuid());
					permission.setPermissionName(name);
					permission.setPermissionSign(sign);
					permission.setUrl(url);
					permission.setDescription(describ);
					if(menu != null){
						permission.setMenuName(menu.getName());
						permission.setMenuType(menu.getType());
					}else{
						permission.setMenuName("");
						permission.setMenuType(0);
					}
					permissionService.insert(permission);
				}
				int allCounts = permissionService.selectAllCounts();
				if(allCounts == 0){
					allCounts = 1;
				}
				Page p = new Page(allCounts,1);
				List<Permission> permissionList = permissionService.selectByPage(p);
				if(permissionList.size() > 0){
					resultMap.put("nums", allCounts);
					resultMap.put("permissionList", permissionList);
					resultMap.put("pages", p);
				}
			}else{
				return new ModelAndView("../login");
			}
				
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		
		return new ModelAndView("/permission/allpermission");
	}
	@RequestMapping(value = "delete")
	@ResponseBody
	public boolean delete(HttpServletRequest request){
		String guid = request.getParameter("guid");
		String[] guidArray = guid.split(",");
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				for(int i = 0;i < guidArray.length;i++){
					rolePermissionService.deleteByPid(guidArray[i]);
					permissionService.deleteByPrimaryKey(guidArray[i]);
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
