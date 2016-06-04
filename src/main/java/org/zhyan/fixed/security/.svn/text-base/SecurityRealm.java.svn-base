package org.zhyan.fixed.security;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;
import org.zhyan.fixed.bean.Permission;
import org.zhyan.fixed.bean.Role;
import org.zhyan.fixed.bean.Role_permission;
import org.zhyan.fixed.bean.User;
import org.zhyan.fixed.bean.User_role;
import org.zhyan.fixed.service.PermissionService;
import org.zhyan.fixed.service.RoleService;
import org.zhyan.fixed.service.Role_permissionService;
import org.zhyan.fixed.service.UserService;
import org.zhyan.fixed.service.User_roleService;


/**
 * 用户身份验证,授权 Realm 组件
 * 
 * @author zhyan
 * @since 2014年6月11日 上午11:35:28
 **/
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private PermissionService permissionService;

    @Resource
    private User_roleService user_roleService;
    
    @Resource 
    private Role_permissionService role_permissionService;
    /**
     * 权限检查
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = String.valueOf(principals.getPrimaryPrincipal());

        final User user = userService.selectByUsername(username);
        final User_role user_role= user_roleService.selectRolesByUserId(user.getGuid());
        
        final Role roleInfos = roleService.selectByPrimaryKey(user_role.getRid());
  //      for (Role role : roleInfos) {
            // 添加角色
   //         System.err.println(role);
            authorizationInfo.addRole(roleInfos.getRoleSign());
            final List<Role_permission> role_permissions = role_permissionService.selectRolePermissionByRid(roleInfos.getGuid());
       //     final List<Permission> permissions = permissionService.selectPermissionsByRoleId(role.getId());
            for (Role_permission role_permission : role_permissions) {
                // 添加权限
          //      System.err.println(permission);
            	Permission permission = permissionService.selectByPrimaryKey(role_permission.getRid());
                authorizationInfo.addStringPermission(permission.getPermissionSign());
            }
  //      }
        return authorizationInfo;
    }

    /**
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = String.valueOf(token.getPrincipal());
        String password = new String((char[]) token.getCredentials());
        System.out.print("开始验证");

        // 通过数据库进行验证
        final User authentication = userService.authentication(new User(username, password));
        if (authentication == null) {
            throw new AuthenticationException("用户名或密码错误.");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
        return authenticationInfo;
    }

}
