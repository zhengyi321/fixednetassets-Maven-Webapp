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
import org.zhyan.fixed.bean.Permission;
import org.zhyan.fixed.bean.Role;
import org.zhyan.fixed.bean.Role_permission;
import org.zhyan.fixed.service.PermissionService;
import org.zhyan.fixed.service.RoleService;
import org.zhyan.fixed.service.Role_permissionService;
import org.zhyan.fixed.util.MD5;
import org.zhyan.fixed.util.Page;

@RequestMapping(value = "rolepermission")
@Controller
public class RolePermissionController {

	@Autowired
	private Role_permissionService rolePermissionService;
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "index")
	@ResponseBody
	public ModelAndView index(HttpServletRequest request,Map<String,Object> resultMap){
		
		String currentIndex = request.getParameter("page");
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				int allCounts = rolePermissionService.selectAllCounts();
				if(allCounts == 0){
					allCounts = 1;
				}
				Page p = new Page(allCounts,Integer.parseInt(currentIndex));
				List<Role_permission> rolePermissionList = rolePermissionService.selectByPage(p);
				if(rolePermissionList.size() > 0){
					resultMap.put("nums", allCounts);
					resultMap.put("rolePermissionList", rolePermissionList);
					resultMap.put("pages", p);
					
				} else {
					resultMap.put("rolePermissionList",rolePermissionList);
					resultMap.put("nums",0);
					resultMap.put("pages",p);
				}
				 resultMap.put("currentpage", "角色权限管理");
			}else{
				return new ModelAndView("../login");
			}
		}catch(AuthenticationException e)
		{
			return new ModelAndView("../login");
		}
		
		return new ModelAndView("/rolepermission/allrolepermission");
	}
	@RequestMapping(value = "add")
	@ResponseBody
	public ModelAndView add(HttpServletRequest request,Map<String,Object> resultMap){
		
		String currentIndex = request.getParameter("page");
		String rid = request.getParameter("rid");
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				int allCounts = permissionService.selectAllCounts();
				if(allCounts == 0){
					allCounts = 1;
				}
				Page p = new Page(allCounts,Integer.parseInt(currentIndex));
				List<Permission> permissionList = permissionService.selectByPage(p);
				List<Role> roleList = roleService.selectAllRoles();
				Role role = roleService.selectByPrimaryKey(rid);
				if(permissionList.size() > 0){
					resultMap.put("pages", p);
					resultMap.put("nums", allCounts);
					resultMap.put("permissionList", permissionList);
				}
				if(role != null){
					resultMap.put("role", role);
				}else{
					role = new Role();
					role.setRoleName("请选择权限");
					resultMap.put("role", role);
				}
				if(roleList.size() > 0){
					resultMap.put("roleList", roleList);
				}
			}else{
				return new ModelAndView("../login");
			}
		}catch(AuthenticationException e){
			return new ModelAndView("../login");
		}
		return new ModelAndView("/rolepermission/add");
	}
	
	@RequestMapping(value = "addsubmit")
	@ResponseBody
	public boolean addSubmit(HttpServletRequest request){
		String pid = request.getParameter("pid");
		String rid = request.getParameter("rid");
		try{
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				if((!rid.isEmpty())&&(rid != null))
				{
					Role role = roleService.selectByPrimaryKey(rid);
					String[] pidArray = pid.split(",");
					for(int i = 0;i < pidArray.length;i++){
						Role_permission rolePermission = rolePermissionService.selectByRidPid(rid, pidArray[i]);
						Permission permission = permissionService.selectByPrimaryKey(pidArray[i]);
						if(rolePermission == null){
							rolePermission = new Role_permission();
							rolePermission.setGuid(MD5.getGuid());
							rolePermission.setRid(rid);
							rolePermission.setRolename(role.getRoleName());
							rolePermission.setPid(pidArray[i]);
							rolePermission.setPermissionname(permission.getPermissionName());
							rolePermissionService.insert(rolePermission);
						}
							
					}
				}
			}else{
				return false;
				
			}
		}catch(AuthenticationException e){
			return false;
		}
		
		return true;
	}
	
	@RequestMapping(value = "delete")
	@ResponseBody
	public boolean delete(HttpServletRequest request){
		String guid = request.getParameter("guid");
		try{
			String[] guidArray = guid.split(",");
			Subject subject = SecurityUtils.getSubject();
			if(subject.isAuthenticated()){
				for(int i=0;i<guidArray.length;i++){
					rolePermissionService.deleteByPrimaryKey(guidArray[i]);
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
