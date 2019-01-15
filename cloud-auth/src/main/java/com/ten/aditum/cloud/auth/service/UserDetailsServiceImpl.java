package com.ten.aditum.cloud.auth.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ten.aditum.cloud.auth.util.StatusCode;
import com.ten.aditum.cloud.auth.vo.MenuVo;
import com.ten.aditum.cloud.auth.vo.Result;
import com.ten.aditum.cloud.auth.vo.RoleVo;
import com.ten.aditum.cloud.auth.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * UserDetailsService接口用于返回用户相关数据。它有loadUserByUsername()方法，
 * 根据username查询用户实体，可以实现该接口覆盖该方法，实现自定义获取用户过程。
 * 该接口实现类被 DaoAuthenticationProvider 类使用，用于认证过程中载入用户信息。
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 调用cloud-data服务查询jdbc数据
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询UserVo
        Result<UserVo> userResult = userService.findByUsername(username);
        if (userResult.getCode() != StatusCode.SUCCESS_CODE) {
            throw new UsernameNotFoundException("用户:" + username + ",不存在!");
        }

        // 设置权限集合
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userResult.getData(), userVo);

        // 查询用户Role列表
        Result<List<RoleVo>> roleResult = roleService.getRoleByUserId(userVo.getId());

        // 查询Role成功
        if (roleResult.getCode() == StatusCode.SUCCESS_CODE) {
            List<RoleVo> roleVoList = roleResult.getData();

            // 遍历用户Role列表
            for (RoleVo role : roleVoList) {
                // 设置用户角色
                // 角色必须是ROLE_开头，可以在数据库中设置
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getValue());
                grantedAuthorities.add(grantedAuthority);

                // 查询用户角色的菜单
                Result<List<MenuVo>> perResult = permissionService.getRolePermission(role.getId());

                // 查询菜单成功
                if (perResult.getCode() == StatusCode.SUCCESS_CODE) {
                    List<MenuVo> permissionList = perResult.getData();

                    // 设置用户菜单
                    for (MenuVo menu : permissionList) {
                        GrantedAuthority authority = new SimpleGrantedAuthority(menu.getCode());
                        grantedAuthorities.add(authority);
                    }
                }
            }
        }

        // 可用性 :true:可用 false:不可用
        boolean enabled = true;
        // 过期性 :true:没过期 false:过期
        boolean accountNonExpired = true;
        // 有效性 :true:凭证有效 false:凭证无效
        boolean credentialsNonExpired = true;
        // 锁定性 :true:未锁定 false:已锁定
        boolean accountNonLocked = true;

        User user = new User(userVo.getUsername(), userVo.getPassword(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return user;
    }
}
