package person.security.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;
import person.ApplicationContextUtils;
import person.db.bean.TblFunctionBean;
import person.db.bean.TblRoleBean;
import person.db.bean.TblUserBean;
import person.handler.UserHandler;
import person.model.UserDetailModel;

import java.util.*;

/**
 * Created by SunChang on 2018/8/22
 */
@SuppressWarnings("deprecation")
public class UserDetailServiceImpl implements UserDetailsService {
    //登陆验证时，通过username获取用户的所有权限信息，
    //并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        boolean enable = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        UserHandler userHandler = (UserHandler) ApplicationContextUtils.getInstance().getBean("userHandler");
        TblUserBean userBean = userHandler.loadByUsername(username);
        if(userBean == null) {

            throw new UsernameNotFoundException("用户名或密码不正确！");
        }
        Collection<GrantedAuthority> auths = obtionGrantedAuthorities(userBean);
        System.out.println("username: " + userBean.getUserCode());
        System.out.println("password: " + userBean.getPassword());
        //这里需要放usercode 和 name
        UserDetailModel user = new UserDetailModel(userBean.getUserCode(), userBean.getPassword(), enable, accountNonExpired, credentialsNonExpired, accountNonLocked, auths);
        user.setEmail(userBean.getEmail());
        user.setId(userBean.getId());
        user.setPassword(userBean.getPassword());
        user.setRoles(userBean.getRoles());
        user.setUserCode(userBean.getUserCode());
        user.setUserName(userBean.getUserName());
        user.setIsBlack(userBean.getIsBlack());
        return user;
    }

    // 取得用户的权限
    private Set<GrantedAuthority> obtionGrantedAuthorities(TblUserBean tblUserBean) {
        Assert.notEmpty(tblUserBean.getRoles(), "当前用户的用户权限为NULL，请检查");
        //if (TblFunctionCache.getInstance().getAll() == null || TblFunctionCache.getInstance().getAll().isEmpty()) {
        //    functionManager.initFunctionCache();
        //}

        Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
        TreeSet<TblRoleBean> roleBeans = tblUserBean.getRoles();
        for (TblRoleBean roleBean : roleBeans) {
            if(StringUtils.isNotBlank(roleBean.getId())) {
                TreeSet<TblFunctionBean> functionBeans = roleBean.getFunctions();
                if (functionBeans != null && !functionBeans.isEmpty()) {
                    for (TblFunctionBean functionBean : functionBeans) {
                        authSet.add(new GrantedAuthorityImpl(functionBean.getId()));
                    }
                }
            }
        }
        return authSet;
    }
}
