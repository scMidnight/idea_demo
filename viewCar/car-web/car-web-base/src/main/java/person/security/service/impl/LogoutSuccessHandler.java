package person.security.service.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import person.model.UserDetailModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SunChang on 2018/8/24
 */
public class LogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {

    /** redirctUrl : 【登出后跳转地址】 **/
    private String redirctUrl="/login.html";

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (authentication != null) {
            //记录登录日志
            //UserDetailModel user = (UserDetailModel)authentication.getPrincipal();
			/*RbacLog log = new RbacLog();
	    	log.setOperateBusiness(BusinessType.USER_MGR.toString());
	    	log.setOperateBusinessMainid(user.getUsername());
	    	log.setOperateDate(new Date());
	    	log.setOperateIp(RequestUtil.getIP(request));
	    	log.setOperateText("登出");
	    	log.setOperateType(LogType.LOGOUT);
	    	log.setOperateUserId(user.getUserId());
	    	log.setOperateUsername(user.getName());
	    	log.setOperateUserType(user.getUserType());
	    	log.setOperationResult("0");
	    	RbacLogHandlerService.addLog(log);*/

            //判断返回结果是否成功
            //if (!"success".equalsIgnoreCase(jsonObject.get("status").getAsString())) {//登录成功 拿出用户信息给接口
            //    throw new AuthenticationServiceException("认证中心登出失败！");
            //}
        }

        //if(redirctUrl.indexOf("http://") > -1){
        //    response.sendRedirect(redirctUrl);
        //}else {
        //    response.sendRedirect(request.getContextPath() + redirctUrl);
        //}
    }

    public String getRedirctUrl() {
        return redirctUrl;
    }

    public void setRedirctUrl(String redirctUrl) {
        this.redirctUrl = redirctUrl;
    }
}
