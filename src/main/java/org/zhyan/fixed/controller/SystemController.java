package org.zhyan.fixed.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.http.HttpResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zhyan.fixed.bean.Menu;
import org.zhyan.fixed.bean.Permission;
import org.zhyan.fixed.bean.Role_permission;
import org.zhyan.fixed.bean.User;
import org.zhyan.fixed.bean.User_role;
import org.zhyan.fixed.service.MenuService;
import org.zhyan.fixed.service.PermissionService;
import org.zhyan.fixed.service.Role_permissionService;
import org.zhyan.fixed.service.UserService;
import org.zhyan.fixed.service.User_roleService;


@RequestMapping(value = "system")
@Controller
public class SystemController {

  @Autowired
  private UserService userService;
  @Autowired
  private User_roleService userRoleService;
  @Autowired
  private Role_permissionService rolePermissionService;
  @Autowired
  private PermissionService permissionService;
  @Autowired
  private MenuService menuService;
	
  @RequestMapping(value = "left")
  @ResponseBody
  public ModelAndView left(HttpServletRequest request,Map<String,Object> resultMap,HttpSession session,HttpServletResponse response) throws IOException{
	  
	  
	  try{
		  Subject subject = SecurityUtils.getSubject();
		  if(subject.isAuthenticated()){
			  User user = (User) session.getAttribute("userInfo"); 
			  User_role userRole = userRoleService.selectRolesByUserId(user.getGuid());
			  List<Role_permission> rolePermissionList = rolePermissionService.selectRolePermissionByRid(userRole.getRid());
			  List<Menu> menuList = menuService.selectAllMenu();
			  response.setContentType("text/html;charset=UTF-8");
		      response.setCharacterEncoding("UTF-8");
		      response.setHeader("Cache-Control", "no-cache");
			  PrintWriter out = response.getWriter();
			  out.println("<HTML>");
			  out.println("<HEAD>");
			  out.println("<SCRIPT src='/fixednetassets/common/Left.files/TreeNode.js' type=text/javascript></SCRIPT>");
			  out.println("<SCRIPT src='/fixednetassets/common/Left.files/Tree.js' type=text/javascript></SCRIPT>");
			  out.println("<LINK href='/fixednetassets/css/left.css' type=text/css rel=stylesheet>");
			  out.println("<META content='MSHTML 6.00.2900.5848' name=GENERATOR>");
			  out.println("</HEAD>");
			  out.println("<BODY style='BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(/fixednetassets/images/bg.gif); BACKGROUND-REPEAT: repeat-x'>");
			  out.println("<TABLE height='100%' cellSpacing=0 cellPadding=0 width='100%'>");
			  out.println("<TBODY>");
			  out.println("<TR>");
			  out.println("<TD width=10 height=29><IMG src='/fixednetassets/common/Left.files/bg_left_tl.gif'></TD>");
			  out.println("<TD style='FONT-SIZE: 18px; BACKGROUND-IMAGE: url(/fixednetassets/images/bg_left_tc.gif); COLOR: white; FONT-FAMILY: system'></TD>");
			  out.println("<TD width=10><IMG src='/fixednetassets/common/Left.files/bg_left_tr.gif'></TD>");
			  out.println("</TR>");
			  out.println("<TR>");
			  out.println("<TD style='BACKGROUND-IMAGE: url(/fixednetassets/images/bg_left_ls.gif)'></TD>");
			  out.println("<TD id=menuTree style='PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; PADDING-TOP: 10px; HEIGHT: 100%; BACKGROUND-COLOR: white' vAlign=top></TD>");
			  out.println("<TD style='BACKGROUND-IMAGE: url(/fixednetassets/images/bg_left_rs.gif)'></TD>");
			  out.println("</TR>");
			  out.println("<TR>");
			  out.println("<TD width=10><IMG src='/fixednetassets/common/Left.files/bg_left_bl.gif'></TD>");
			  out.println("<TD style='BACKGROUND-IMAGE: url(/fixednetassets/images/bg_left_bc.gif)'></TD>");
			  out.println("<TD width=10><IMG src='/fixednetassets/common/Left.files/bg_left_br.gif'></TD>");
			  out.println("</TR>");
			  out.println("</TBODY>");
			  out.println("</TABLE>");
			  out.println("</BODY>");
			  out.println("</HTML>");			  
			  out.println("<script type=text/javascript>");
			  System.out.println("<script type=text/javascript>");
			  out.println("var tree = null;");
			  System.out.println("var tree = null;");
			  out.println("var root = new TreeNode('系统菜单');");
			  System.out.println("var root = new TreeNode('系统菜单');");
			  if(rolePermissionList.size() > 0){
				  String temp = "";
				  
				  for(int i=0;i<menuList.size();i++){
					  temp = "fun"+i; 
					  out.println("var "+temp+" = new TreeNode('"+menuList.get(i).getName()+"');");
					  System.out.println("var "+temp+" = new TreeNode('"+menuList.get(i).getName()+"');");
					  for(int j=0;j<rolePermissionList.size();j++){
						  Permission permission = permissionService.selectByPrimaryKey(rolePermissionList.get(j).getPid());
						  if(menuList.get(i).getType() == permission.getMenuType()){
							  out.println("var node"+j+" = new TreeNode('"+permission.getPermissionName()+"', '"+permission.getUrl()+"', 'tree_node.gif', null, 'tree_node.gif', null);");
							  System.out.println("var node"+j+" = new TreeNode('"+permission.getPermissionName()+"', '"+permission.getUrl()+"', 'tree_node.gif', null, 'tree_node.gif', null);");
							  out.println(temp+".add(node"+j+");");	
							  System.out.println(temp+".add(node"+j+");");
						  }
					  }
					  out.println("root.add("+temp+");");
					  System.out.println("root.add("+temp+");");
				  }
				  
			  }
		  
			  out.println("tree = new Tree(root);");
			  System.out.println("tree = new Tree(root);");
			  out.println("tree.show('menuTree');");
			  System.out.println("tree.show('menuTree')");
			  out.println("</script>");
			  System.out.println("</script>");
			  out.flush();
			  out.close();
		  } else {
			  return new ModelAndView("../login");
		  }
	  }catch(AuthenticationException e)
	  {
		  return new ModelAndView("../login");
	  }
	  
	  
	 
	  return new ModelAndView("/common/left");
  }
	
  @RequestMapping(value = "right")
  @ResponseBody
  public ModelAndView right(HttpServletRequest request){
	  
	  return new ModelAndView("/common/right");
  }
  
  @RequestMapping(value = "top")
  @ResponseBody
  public ModelAndView top(HttpServletRequest request){
	  
	  return new ModelAndView("/common/top");
  }
  
  @RequestMapping(value = "index")
  @ResponseBody
  public ModelAndView index(HttpServletRequest request) {
		
	  return new ModelAndView("/common/index");
  }
  @RequestMapping(value="loginout")
  @ResponseBody
  public ModelAndView loginout(HttpServletRequest request,HttpSession session){
	  try{
		  User user = (User) session.getAttribute("userInfo");
		  user.setState("下线");
		  userService.updateByPrimaryKey(user);
		  session.removeAttribute("userInfo");
		  Subject subject = SecurityUtils.getSubject();
		  subject.logout();
	  }catch(Exception e)
	  {
		  
	  }
	  return new ModelAndView("../login");
  }
  
  
  @RequestMapping(value = "login")
  @ResponseBody
  public ModelAndView login(@Valid User user, BindingResult result,Model model,HttpServletRequest request , HttpSession session,Map<String,Object> resultMap){
	  		String logintime = request.getParameter("logintime");
	  		String year = request.getParameter("year");
	  try{
			Subject subject = SecurityUtils.getSubject();
            if (result.hasErrors()) {
                model.addAttribute("error", "参数错误！");
                return new ModelAndView("../login");
            }
            
            // 身份验证
            subject.login(new UsernamePasswordToken(user.getName(), user.getPass()));
            // 验证成功在Session中保存用户信息
            User authUserInfo = userService.selectByUsername(user.getName());
            authUserInfo.setState("上线状态");
            session.setAttribute("userInfo", authUserInfo);
            session.setAttribute("year", year);
            session.setAttribute("logintime", logintime);
			   // 已登陆则 跳到首页
            if (subject.isAuthenticated()) {
            	
            	userService.updateByPrimaryKey(authUserInfo);
            }else
            {
            	return new ModelAndView("../login");
            }
		}catch(AuthenticationException e)
		{
			// 身份验证失败
            model.addAttribute("error", "用户名或密码错误 ！");
			return new ModelAndView("../login");
		}
	  return new ModelAndView("/common/index");
  }
  
  @RequestMapping(value = "editpass")
  @ResponseBody
  public ModelAndView editPass(HttpServletRequest request){
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
	  return new ModelAndView("/common/editpass");
  }
  
}
