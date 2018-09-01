package person.util;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import person.db.bean.TblUserBean;
import person.model.UserDetailModel;

import java.util.Collection;
import java.util.Map;

/**
 * Created by SunChang on 2018/8/28
 */
public class UserUtil {
    /**
     * 获取用户名
     *
     * @return
     */
    public static String getName() {
        String returnString = "anonymous";
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (checkLogin(authentication)) {
            UserDetailModel details = (UserDetailModel) authentication.getPrincipal();
            returnString = details.getUserCode();
        }

        return returnString;
    }

    /**
     * 获取用户权限
     */
    public static Collection<GrantedAuthority> getAuthorities() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserDetailModel details = (UserDetailModel) authentication.getPrincipal();
        return details.getAuthorities();
    }

    /**
     * 获取登陆名
     */
    /**
     * 获取用户名
     *
     * @return
     */
    public static String getLoginName() {
        String returnString = "anonymous";
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (checkLogin(authentication)) {
            UserDetailModel details = (UserDetailModel) authentication.getPrincipal();
            returnString = details.getUsername();
        }
        return returnString;
    }

    /**
     * author:yjc
     * 时间：2016 2016-3-30 下午4:40:02
     * 描述：获取userId号
     */
    public static String getUserId() {
        String returnString = "";
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (checkLogin(authentication)) {
            UserDetailModel details = (UserDetailModel) authentication.getPrincipal();
            returnString = details.getId();
        }
        return returnString;
    }

    /**
     * 检查用户是否登录
     */
    public static Boolean checkLogin(Authentication authentication) {
        Boolean isLogin = true;
        if (null == authentication || "anonymousUser".equals(authentication.getName())) {
            isLogin = false;
        }
        return isLogin;
    }

    /**
     * 获取用户ip
     */
    public static String getAddressIP() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
        return details.getRemoteAddress();
    }



    /**
     * 获取用户
     */
    public static UserDetailModel getUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (checkLogin(authentication)) {
            UserDetailModel details = (UserDetailModel) authentication.getPrincipal();
            return details;
        }else {
            return null;
        }
    }
}
