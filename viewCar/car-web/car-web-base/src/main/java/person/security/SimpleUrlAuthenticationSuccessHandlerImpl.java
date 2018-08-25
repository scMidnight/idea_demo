package person.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import person.db.bean.TblFunctionBean;
import person.db.bean.TblRoleBean;
import person.model.UserDetailModel;
import person.security.service.UserSessionManager;
import person.security.service.impl.UserSessionManagerImpl;
import person.util.MenuObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by SunChang on 2018/8/23
 */
public class SimpleUrlAuthenticationSuccessHandlerImpl extends SimpleUrlAuthenticationSuccessHandler {

    private UserSessionManager userSessionManager = new UserSessionManagerImpl();

    private RequestCache requestCache;

    public SimpleUrlAuthenticationSuccessHandlerImpl() {
        requestCache = new HttpSessionRequestCache();
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetailModel user = (UserDetailModel) authentication.getPrincipal();
        request.getSession().setAttribute("user_name", user.getUsername());
        request.getSession().setAttribute("user", user);

        List<TblFunctionBean> first = new ArrayList<TblFunctionBean>();
        List<TblFunctionBean> second = new ArrayList<TblFunctionBean>();
        List<TblFunctionBean> third = new ArrayList<TblFunctionBean>();

        TreeSet<TblRoleBean> roleList = user.getRoles();
        Set<String> functionSet = new HashSet<String>();

        /****
         * 只做到三级菜单
         */
        for (TblRoleBean roleBean : roleList) {
            TreeSet<TblFunctionBean> functionBeans = roleBean.getFunctions();
            for (TblFunctionBean functionBean : functionBeans) {
                if(functionSet.add(functionBean.getId())) {
                    if (functionBean.getId().length() == 4 && functionBean.getFunctionLevel().equals("1")) {
                        first.add(functionBean);
                    } else if (functionBean.getId().length() == 7 && functionBean.getFunctionLevel().equals("2")) {
                        second.add(functionBean);
                    } else if (functionBean.getId().length() == 10 && functionBean.getFunctionLevel().equals("3")) {
                        third.add(functionBean);
                    }
                }
            }
        }
        List<MenuObject> tree = new ArrayList<MenuObject>();
        for (TblFunctionBean function : first) {
            MenuObject treeObj = new MenuObject();
            treeObj.setObj(function);
            List<MenuObject> children = new ArrayList<MenuObject>();
            for (TblFunctionBean function1 : second) {
                if (function1.getId().startsWith(function.getId())) {
                    MenuObject treeObj1 = new MenuObject();
                    treeObj1.setObj(function1);
                    List<MenuObject> children1 = new ArrayList<MenuObject>();
                    for (TblFunctionBean function2 : third) {
                        if (function2.getId().startsWith(function1.getId())) {
                            MenuObject treeObj2 = new MenuObject();
                            treeObj2.setObj(function2);
                            children1.add(treeObj2);
                        }
                    }
                    treeObj1.setChildren(children1);
                    children.add(treeObj1);
                }
            }
            treeObj.setChildren(children);
            tree.add(treeObj);
        }
        request.getSession().setAttribute("tree", tree);
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest == null) {
            super.onAuthenticationSuccess(request, response, authentication);
            return;
        }
        String targetUrlParameter = getTargetUrlParameter();
        if (isAlwaysUseDefaultTargetUrl() || targetUrlParameter != null && StringUtils.hasText(request.getParameter(targetUrlParameter))) {
            requestCache.removeRequest(request, response);
            super.onAuthenticationSuccess(request, response, authentication);
            return;
        } else {
            clearAuthenticationAttributes(request);
            String targetUrl = savedRequest.getRedirectUrl();
            logger.debug((new StringBuilder()).append("Redirecting to DefaultSavedRequest Url: ").append(targetUrl).toString());
            getRedirectStrategy().sendRedirect(request, response, targetUrl);
            return;
        }
    }

    public UserSessionManager getUserSessionManager() {
        return userSessionManager;
    }

    public void setUserSessionManager(UserSessionManager userSessionManager) {
        this.userSessionManager = userSessionManager;
    }

    public RequestCache getRequestCache() {
        return requestCache;
    }

    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }
}
