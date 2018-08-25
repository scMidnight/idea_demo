package person.security.service;

import person.model.UserDetailModel;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SunChang on 2018/8/23
 */
public interface UserSessionManager {
    /**
     * 将接收到的用户信息转换为应用自己的用户类型并存入Session
     * @param request
     * @param userDetailModel
     */
    void loadUserSession(HttpServletRequest request, UserDetailModel userDetailModel);
}
